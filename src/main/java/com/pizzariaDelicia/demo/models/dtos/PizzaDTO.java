package com.pizzariaDelicia.demo.models.dtos;

import com.pizzariaDelicia.demo.models.Pizza;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class PizzaDTO {

    private int id;
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;
    private float precoBase;
    private boolean personalizada;

    public PizzaDTO(Pizza pizza) {
        this.id = pizza.getId();
        this.nome = pizza.getNome();
        this.precoBase = pizza.getPrecoBase();
        this.personalizada = pizza.isPersonalizada();
    }

    public static  Pizza convert(PizzaDTO pizzaDTO){
        Pizza pizza = new Pizza();
        pizza.setId(pizzaDTO.getId());
        pizza.setNome(pizzaDTO.getNome());
        pizza.setPrecoBase(pizzaDTO.getPrecoBase());
        pizza.setPersonalizada(pizzaDTO.isPersonalizada());
        return pizza;
    }

    public PizzaDTO(int id) {
        this.id = id;
    }

    public PizzaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(float precoBase) {
        this.precoBase = precoBase;
    }

    public boolean isPersonalizada() {
        return personalizada;
    }

    public void setPersonalizada(boolean personalizada) {
        this.personalizada = personalizada;
    }
}
