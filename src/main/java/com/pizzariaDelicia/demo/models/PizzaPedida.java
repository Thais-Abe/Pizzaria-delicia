package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizzaPedida")
@Embeddable
public class PizzaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    //muitas pizzas para 1 pedido
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "idPizza")
    private Pizza pizza;
    @ManyToOne
    @JoinColumn(name = "idTamanho")
    private Tamanho tamanho;
    @Column(nullable = false)
    private byte quantidade;
}
