package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 100)
    private String nome;
    @Column(nullable = false,length = 100)
    private String telefone;

    @Column(nullable = false,length = 200)
    private String endereco;

    @Column(nullable = false,length = 30)
    private String login;

    @Column(nullable = false,length = 30)
    private String senha;
}
