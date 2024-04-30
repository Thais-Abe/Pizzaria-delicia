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

    public Fornada() {
    }

    public Fornada(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getNumFornada() {
        return numFornada;
    }

    public void setNumFornada(byte numFornada) {
        this.numFornada = numFornada;
    }

    public byte getQtdPizzas() {
        return qtdPizzas;
    }

    public void setQtdPizzas(byte qtdPizzas) {
        this.qtdPizzas = qtdPizzas;
    }
}
