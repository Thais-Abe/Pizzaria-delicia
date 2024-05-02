package com.pizzariaDelicia.demo.services;

import com.pizzariaDelicia.demo.models.Cliente;
import com.pizzariaDelicia.demo.models.dtos.ClienteDTO;
import com.pizzariaDelicia.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //salvar
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = ClienteDTO.convert(clienteDTO);
        cliente = this.clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

    //recupera clientes do banco
    public List<ClienteDTO> retornarTodosClientes() {
        List<Cliente> clienteLista = this.clienteRepository.findAll();
        return clienteLista.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO acharClientePorID(long id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("O cliente não foi encontrado");
        }else {
            return new ClienteDTO(cliente.get());
        }
    }

    public ClienteDTO fazerAleracoesCliente(ClienteDTO clienteDTO,long id) {
        this.acharClientePorID(id);
        Cliente cliente = ClienteDTO.convert(clienteDTO);
        cliente.setId(cliente.getId());
        this.clienteRepository.save(cliente);
        return new ClienteDTO(cliente);
    }

    public ClienteDTO deletar(long id){
        ClienteDTO clienteDTO = acharClientePorID(id);
        this.clienteRepository.deleteById(id);
        return clienteDTO;
    }
}
