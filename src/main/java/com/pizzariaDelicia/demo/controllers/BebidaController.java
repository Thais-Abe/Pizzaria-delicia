package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.BebidaDTO;

import com.pizzariaDelicia.demo.services.BebidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;
    @GetMapping
    public List<BebidaDTO> retornarBebidas(){
        return this.bebidaService.retornarBebidas();
    }
    @PostMapping
    public BebidaDTO salvar(@RequestBody @Valid BebidaDTO bebidaDTO){
        return this.bebidaService.salvar(bebidaDTO);
    }

    @PutMapping("/{id}")
    public BebidaDTO alterarBebidaPeloID(@RequestBody BebidaDTO bebidaDTO, @PathVariable int id){
        return  this.bebidaService.alterarBebidaPeloID(bebidaDTO, id);
    }

    @DeleteMapping("/{id}")
    public BebidaDTO deletarBebidaPorID(@PathVariable int id){
        return  this.bebidaService.deletarBebidaPorID(id);
    }

}
