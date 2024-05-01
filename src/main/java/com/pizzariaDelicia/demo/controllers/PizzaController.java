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
    public PizzaDTO getPizzaById(@PathVariable long id){
        return this.pizzaService.getPizzaById(id);
    }
    @PostMapping
    public PizzaDTO save(@RequestBody @Valid PizzaDTO pizzaDTO){
        return this.pizzaService.save(pizzaDTO);
    }

    @PutMapping("/{id}")
    public PizzaDTO updatePizzaById(@PathVariable long id, @RequestBody @Valid PizzaDTO pizzaDTO){
        return this.pizzaService.updatePizzaById(id, pizzaDTO);
    }

    @DeleteMapping("/{id}")
    public PizzaDTO deleteById(@PathVariable long id){
        return this.pizzaService.deleteById(id);
    }


}
