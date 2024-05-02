package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente,Integer> {
}
