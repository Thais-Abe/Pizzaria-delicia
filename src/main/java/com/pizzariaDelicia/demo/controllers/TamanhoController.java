package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.BebidaDTO;
import com.pizzariaDelicia.demo.models.dtos.TamanhoDTO;
import com.pizzariaDelicia.demo.services.BebidaService;
import com.pizzariaDelicia.demo.services.TamanhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("tamanho-da-pizza")
public class TamanhoController {

    @Autowired
    private TamanhoService tamanhoService;
    @GetMapping
    public List<TamanhoDTO> retornarTodosTamanhos(){
        return this.tamanhoService.retornarTodosTamanhos();
    }
    @PostMapping
    public TamanhoDTO salvarTamanho(@RequestBody @Valid TamanhoDTO tamanhoDTO){
        return this.tamanhoService.salvarTamanho(tamanhoDTO);
    }

    @PutMapping("/{id}")
    public TamanhoDTO modificarTamanhoPorID(@RequestBody TamanhoDTO tamanhoDTO, @PathVariable byte id){
        return  this.tamanhoService.modificarTamanhoPorID(tamanhoDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deletarTamanhoPorID(@PathVariable byte id){
        return this.tamanhoService.deletarTamanhoPorID(id);
    }
}
