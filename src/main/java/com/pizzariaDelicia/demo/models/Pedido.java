package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "fornada_id")
    private Fornada fornada;
    private LocalDate dataHora;
}
