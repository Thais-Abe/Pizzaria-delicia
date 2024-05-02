package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.FornadaDTO;
import com.pizzariaDelicia.demo.models.dtos.PizzaDTO;
import com.pizzariaDelicia.demo.services.FornadaService;
import com.pizzariaDelicia.demo.services.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornada")
public class FornadaController {
    @Autowired
    private FornadaService fornadaService;

    @GetMapping("/{id}")
    public FornadaDTO retornarQuantidadeDeFornadasPeloID(@PathVariable byte id){
        return this.fornadaService.retornarQuantidadeDeFornadasPeloID(id);
    }
    @PostMapping
    public FornadaDTO salvarFornada(@RequestBody @Valid FornadaDTO fornadaDTO){
        return this.fornadaService.salvarFornada(fornadaDTO);
    }

    @PutMapping("/{id}")
    public FornadaDTO realizarAlteracoesPizza(@PathVariable byte id, @RequestBody @Valid FornadaDTO fornadaDTO){
        return this.fornadaService.modificarFornada(id, fornadaDTO);
    }

    @DeleteMapping("/{id}")
    public String deletarFornadaPorID(@PathVariable byte id){
        return this.fornadaService.deletarFornadaPorID(id);
    }
}
