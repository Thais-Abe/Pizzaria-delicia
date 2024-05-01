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
    public List<TamanhoDTO> findTamanhoById(){
        return this.tamanhoService.findAllTamanhos();
    }
    @PostMapping
    public TamanhoDTO save(@RequestBody @Valid TamanhoDTO tamanhoDTO){
        return this.tamanhoService.save(tamanhoDTO);
    }

    @PutMapping("/{id}")
    public TamanhoDTO updateDrinkById(@RequestBody TamanhoDTO tamanhoDTO, @PathVariable byte id){
        return  this.tamanhoService.updateTamanhoById(tamanhoDTO, id);
    }

    @DeleteMapping("/{id}")
    public String deleteTamanhoById(@PathVariable byte id){
        return this.tamanhoService.deleteTamanhoById(id);
    }
}
