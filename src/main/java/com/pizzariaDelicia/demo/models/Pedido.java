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
    private Cliente idCliente;
    @ManyToOne
    @JoinColumn(name = "idFornada")
    private Fornada idFornada;
    private LocalDate dataHora;

    public Pedido(long id) {
        this.id = id;
    }

    public Pedido() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Fornada getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(Fornada idFornada) {
        this.idFornada = idFornada;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }
}
