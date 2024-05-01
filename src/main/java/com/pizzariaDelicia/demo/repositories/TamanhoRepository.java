package com.pizzariaDelicia.demo.repositories;

import com.pizzariaDelicia.demo.models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TamanhoRepository extends JpaRepository<Tamanho,Byte> {
}
