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
    public PizzaDTO save(PizzaDTO pizzaDTO) {
        Pizza pizza = PizzaDTO.convert(pizzaDTO);
        pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);
    }


    public PizzaDTO getPizzaById(long id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);
        if(pizza.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }else {
            return new PizzaDTO(pizza.get());
        }
    }

    public PizzaDTO updatePizzaById(long id, PizzaDTO pizzaDTO) {
        this.getPizzaById(id);
        Pizza pizza = PizzaDTO.convert(pizzaDTO);
        pizza = pizzaRepository.save(pizza);
        return new PizzaDTO(pizza);

    }

    public PizzaDTO deleteById(long id) {
        PizzaDTO pizzaDTO = getPizzaById(id);
       this.pizzaRepository.deleteById(id);
       return pizzaDTO;
    }
}
