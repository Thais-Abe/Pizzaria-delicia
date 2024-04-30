package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pizzaPedida_has_ingrediente")
public class PizzaPedida_has_Ingrediente {
    @EmbeddedId
   private PizzaPedida_has_IngredienteId id;
}
