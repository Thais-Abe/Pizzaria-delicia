package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fornada")
public class Fornada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;
    private byte numFornada;
    private byte qtdPizzas;
}
