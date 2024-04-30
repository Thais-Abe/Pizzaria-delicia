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
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idFornada")
    private Fornada fornada;
    private LocalDate dataHora;
}
