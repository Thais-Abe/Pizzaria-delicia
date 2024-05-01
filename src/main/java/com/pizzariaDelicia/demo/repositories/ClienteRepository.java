package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
