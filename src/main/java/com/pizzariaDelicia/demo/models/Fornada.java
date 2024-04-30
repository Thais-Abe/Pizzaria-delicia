package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fornada")
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;
    @Column(nullable = false)
    private byte numFornada;
    @Column(nullable = false)
    private byte qtdPizzas;
}
