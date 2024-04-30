package com.pizzariaDelicia.demo.models.dtos;

import com.pizzariaDelicia.demo.models.Tamanho;
import jakarta.validation.constraints.NotBlank;

public class TamanhoDTO {
    private byte id;
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;

    private Float desconto;

    public TamanhoDTO(Tamanho tamanho) {
        this.id = tamanho.getId();
        this.nome = tamanho.getNome();
        this.desconto = tamanho.getDesconto();
    }

    public static Tamanho convert(TamanhoDTO tamanhoDTO){
        Tamanho tamanho = new Tamanho();
        tamanho.setId(tamanhoDTO.getId());
        tamanho.setNome(tamanhoDTO.getNome());
        tamanho.setDesconto(tamanhoDTO.getDesconto());
        return tamanho;
    }

    public TamanhoDTO(byte id) {
        this.id = id;
    }

    public TamanhoDTO() {
    }



    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }
}
