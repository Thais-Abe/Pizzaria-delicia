package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.ClienteDTO;
import com.pizzariaDelicia.demo.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService ;

    @GetMapping
    public List<ClienteDTO> retornarTodosClientes(){
        return this.clienteService.retornarTodosClientes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClienteDTO acharClientePorID(@PathVariable long id){
        return this.clienteService.acharClientePorID(id);
    }
    @PostMapping
    public ClienteDTO save(@RequestBody @Valid ClienteDTO clienteDTO){
        return this.clienteService.save(clienteDTO);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ClienteDTO fazerAleracoesCliente(@RequestBody @Valid ClienteDTO clienteDTO, @PathVariable long id){
        return this.clienteService.fazerAleracoesCliente(clienteDTO, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ClienteDTO deletar(@PathVariable long id){
        return this.clienteService.deletar(id);
    }
}
