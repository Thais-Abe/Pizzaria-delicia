package com.pizzariaDelicia.demo.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class PizzaPedida_has_IngredienteId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idPizzaPedida")
    private PizzaPedida pizzaPedida;

    @ManyToOne
    @JoinColumn(name = "idIngrediente")
    private Ingrediente ingrediente;
}
