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
    public List<ClienteDTO> findAll(){
        return this.clienteService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ClienteDTO findById(@PathVariable long id){
        return this.clienteService.findById(id);
    }
    @PostMapping
    public ClienteDTO save(@RequestBody @Valid ClienteDTO clienteDTO){
        return this.clienteService.save(clienteDTO);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ClienteDTO updateById(@RequestBody @Valid ClienteDTO clienteDTO){
        return this.clienteService.updateById(clienteDTO);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ClienteDTO deleteById(@PathVariable long id){
        return this.clienteService.deleteById(id);
    }
}
