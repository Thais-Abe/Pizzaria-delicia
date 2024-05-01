package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.PizzaPedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaPedidoRepository extends JpaRepository<PizzaPedida, Long> {
}
