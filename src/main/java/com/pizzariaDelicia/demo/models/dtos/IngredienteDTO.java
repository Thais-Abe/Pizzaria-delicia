package com.pizzariaDelicia.demo.models.dtos;


import com.pizzariaDelicia.demo.models.Ingrediente;
import jakarta.validation.constraints.NotBlank;

public class IngredienteDTO {

    private int id;
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;
    @NotBlank(message = "O preço deve ser preenchido")
    private float preco;

    public IngredienteDTO(Ingrediente ingrediente) {
        this.id = ingrediente.getId();
        this.nome = ingrediente.getNome();
        this.preco = ingrediente.getPreco();
    }

    public static Ingrediente convert(IngredienteDTO ingredienteDTO){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(ingrediente.getId());
        ingrediente.setNome(ingredienteDTO.getNome());
        ingrediente.setPreco(ingredienteDTO.getPreco());
        return ingrediente;
    }

    public IngredienteDTO(int id) {
        this.id = id;
    }

    public IngredienteDTO() {
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
