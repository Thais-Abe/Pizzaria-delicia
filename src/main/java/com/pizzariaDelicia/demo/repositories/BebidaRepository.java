package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Integer> {
}
