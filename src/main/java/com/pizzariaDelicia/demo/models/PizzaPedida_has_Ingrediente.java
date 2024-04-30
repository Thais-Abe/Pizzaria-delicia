package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizzaPedida_has_ingrediente")
public class PizzaPedida_has_Ingrediente {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn()
    private Ingrediente ingrediente;
}
