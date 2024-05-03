package com.pizzariaDelicia.demo.services;

import com.pizzariaDelicia.demo.exceptiohandler.ResourceNotFoundException;
import com.pizzariaDelicia.demo.models.Cliente;
import com.pizzariaDelicia.demo.models.dtos.ClienteDTO;
import com.pizzariaDelicia.demo.models.dtos.ClienteDTOComRecord;
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
    public ClienteDTOComRecord save(ClienteDTOComRecord clienteDTOComRecord) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTOComRecord.nome());
        cliente.setTelefone(clienteDTOComRecord.telefone());
        cliente.setEndereco(clienteDTOComRecord.endereco());
        cliente.setLogin(clienteDTOComRecord.login());
        cliente.setSenha(clienteDTOComRecord.senha());
        this.clienteRepository.save(cliente);
        return new ClienteDTOComRecord(cliente.getNome(),cliente.getTelefone(),cliente.getEndereco(),cliente.getLogin(), cliente.getSenha());
    }

    //recupera clientes do banco
    public List<ClienteDTO> retornarTodosClientes() {
        List<Cliente> clienteLista = this.clienteRepository.findAll();
        return clienteLista.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTOComRecord acharClientePorID(long id){
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado" + id);
        }else {
            return new ClienteDTOComRecord(cliente.get().getNome(), cliente.get().getTelefone(), cliente.get().getEndereco(), cliente.get().getLogin(), cliente.get().getSenha());
        }
    }

    public ClienteDTOComRecord fazerAleracoesCliente(ClienteDTOComRecord clienteDTOComRecord, long id) {
        this.acharClientePorID(id);//retorna o cliente salvo no banco de dados
//        Cliente cliente = ClienteDTO.convert(clienteDTOTeste);
//        cliente.setId(cliente.getId());
//        this.clienteRepository.save(cliente);

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(clienteDTOComRecord.nome());
        cliente.setTelefone(clienteDTOComRecord.telefone());
        cliente.setEndereco(clienteDTOComRecord.endereco());
        cliente.setLogin(clienteDTOComRecord.login());
        cliente.setSenha(clienteDTOComRecord.senha());
        this.clienteRepository.save(cliente);
        return new ClienteDTOComRecord(cliente.getNome(),cliente.getTelefone(),cliente.getEndereco(),cliente.getLogin(), cliente.getSenha());

    }

    public ClienteDTOComRecord deletar(long id){
        ClienteDTOComRecord clienteDTOComRecord = acharClientePorID(id);
        this.clienteRepository.deleteById(id);
        return clienteDTOComRecord;
    }
}
