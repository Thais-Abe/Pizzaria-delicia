package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizzaPedida")
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    //muitas pizzas para 1 pedido
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
    @ManyToOne
    @JoinColumn(name = "tamanho_id")
    private Tamanho tamanho;
    private byte quantidade;
}
