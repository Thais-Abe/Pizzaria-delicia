package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.PizzaDTO;
import com.pizzariaDelicia.demo.services.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/{id}")
    public PizzaDTO retornarPizzaPeloID(@PathVariable long id){
        return this.pizzaService.retornarPizzaPeloID(id);
    }
    @PostMapping
    public PizzaDTO salvarPizza(@RequestBody @Valid PizzaDTO pizzaDTO){
        return this.pizzaService.salvarPizza(pizzaDTO);
    }

    @PutMapping("/{id}")
    public PizzaDTO realizarAlteracoesPizza(@PathVariable long id, @RequestBody @Valid PizzaDTO pizzaDTO){
        return this.pizzaService.RealizarAlteracoesPizza(id, pizzaDTO);
    }

    @DeleteMapping("/{id}")
    public PizzaDTO deletarPizzaPorID(@PathVariable long id){
        return this.pizzaService.deletarPizzaPorID(id);
    }


}
