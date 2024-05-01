package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
