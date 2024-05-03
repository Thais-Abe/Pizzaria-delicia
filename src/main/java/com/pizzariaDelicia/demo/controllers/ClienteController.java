package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.ClienteDTO;
import com.pizzariaDelicia.demo.models.dtos.ClienteDTOComRecord;
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
    public ClienteDTOComRecord acharClientePorID(@PathVariable long id){
        return this.clienteService.acharClientePorID(id);
    }
    @PostMapping
    public ClienteDTOComRecord save(@RequestBody @Valid ClienteDTOComRecord clienteDTOComRecord){
        return this.clienteService.save(clienteDTOComRecord);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ClienteDTOComRecord fazerAleracoesCliente(@RequestBody @Valid ClienteDTOComRecord clienteDTOComRecord, @PathVariable long id){
        return this.clienteService.fazerAleracoesCliente(clienteDTOComRecord, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ClienteDTOComRecord deletar(@PathVariable long id){
        return this.clienteService.deletar(id);
    }
}
