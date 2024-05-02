package com.pizzariaDelicia.demo.services;

import com.pizzariaDelicia.demo.models.Pizza;
import com.pizzariaDelicia.demo.models.dtos.PizzaDTO;
import com.pizzariaDelicia.demo.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    public PizzaDTO salvarPizza(PizzaDTO pizzaDTO) {
        Pizza pizza = PizzaDTO.convert(pizzaDTO);
        pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);
    }


    public PizzaDTO retornarPizzaPeloID(long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }else {
            return new PizzaDTO(pizza.get());
        }
    }

    public PizzaDTO RealizarAlteracoesPizza(long id, PizzaDTO pizzaDTO) {
        this.retornarPizzaPeloID(id);
        Pizza pizza = PizzaDTO.convert(pizzaDTO);
        pizza = pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);

    }

    public PizzaDTO deletarPizzaPorID(long id) {
        PizzaDTO pizzaDTO = retornarPizzaPeloID(id);
       this.pizzaRepository.deleteById(id);
       return pizzaDTO;
    }
}
