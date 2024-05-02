package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.BebidaPedida;
import com.pizzariaDelicia.demo.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaPedidaRepository extends JpaRepository<BebidaPedida, Pedido> {
}
