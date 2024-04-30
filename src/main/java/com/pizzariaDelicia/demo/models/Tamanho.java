package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tamanho")
public class Tamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;
    @Column(length = 50)
    private String nome;
    private Float desconto;
}
