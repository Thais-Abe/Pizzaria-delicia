package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100)
    private String nome;
    @Column(length = 100)
    private String telefone;

    @Column(length = 200)
    private String endereco;

    @Column(length = 30)
    private String login;

    @Column(length = 30)
    private String senha;
}
