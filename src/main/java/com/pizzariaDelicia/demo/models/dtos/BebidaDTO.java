package com.pizzariaDelicia.demo.models.dtos;


import com.pizzariaDelicia.demo.models.Bebida;
import jakarta.validation.constraints.NotBlank;

public class BebidaDTO {

    private int id;
    @NotBlank(message = "O nome da bebida deve ser preenchido")
    private String nome;

    private float preco;


    public BebidaDTO(Bebida bebida) {
        this.id = bebida.getId();
        this.nome = bebida.getNome();
        this.preco = bebida.getPreco();
    }

    public static Bebida convert(BebidaDTO bebidaDTO){
        Bebida bebida = new Bebida();
        bebida.setId(bebidaDTO.getId());
        bebida.setNome(bebidaDTO.getNome());
        bebida.setPreco(bebidaDTO.getPreco());
        return bebida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BebidaDTO(int id) {
        this.id = id;
    }

    public BebidaDTO() {
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
