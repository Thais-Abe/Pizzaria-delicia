package com.pizzariaDelicia.demo.models.dtos;

import com.pizzariaDelicia.demo.models.Fornada;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class FornadaDTO {

    private byte id;

    private byte numFornada;
    @NotBlank(message = "A quantidade de pizzas deve ser preenchida")
    private byte qtdPizzas;


    public FornadaDTO(Fornada fornada) {
        this.id = fornada.getId();
        this.numFornada = fornada.getNumFornada();
        this.qtdPizzas = fornada.getQtdPizzas();
    }

    public static Fornada convert(FornadaDTO fornadaDTO){
        Fornada fornada = new Fornada();
        fornada.setId(fornadaDTO.getId());
        fornada.setNumFornada(fornadaDTO.getNumFornada());
        fornada.setQtdPizzas(fornadaDTO.getQtdPizzas());
        return fornada;
    }

    public FornadaDTO() {
    }

    public FornadaDTO(byte id) {
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
