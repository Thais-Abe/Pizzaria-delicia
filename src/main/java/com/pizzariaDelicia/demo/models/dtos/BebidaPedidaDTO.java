package com.pizzariaDelicia.demo.models.dtos;

import com.pizzariaDelicia.demo.models.Bebida;
import com.pizzariaDelicia.demo.models.BebidaPedida;
import com.pizzariaDelicia.demo.models.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class BebidaPedidaDTO {


    private long idpedido;

    private Bebida idbebida;
    @NotBlank(message = "A quantidade de bebida deve ser preenchida")
    private byte quantidade;

    public BebidaPedidaDTO(BebidaPedida bebidaPedida) {
        this.idpedido = bebidaPedida.getIdpedido().getId();
        this.idbebida = bebidaPedida.getIdbebida();
        this.quantidade = bebidaPedida.getQuantidade();
    }

    public static BebidaPedida convert(BebidaPedidaDTO bebidaPedidaDTO){
        BebidaPedida bebidaPedida = new BebidaPedida();
        bebidaPedida.setIdpedido(new Pedido(bebidaPedidaDTO.getIdpedido()));
        bebidaPedida.setIdbebida(bebidaPedidaDTO.getIdbebida());
        bebidaPedida.setQuantidade(bebidaPedidaDTO.getQuantidade());
        return bebidaPedida;
    }


    public BebidaPedidaDTO() {
    }

    public long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(long idpedido) {
        this.idpedido = idpedido;
    }

    public Bebida getIdbebida() {
        return idbebida;
    }

    public void setIdbebida(Bebida idbebida) {
        this.idbebida = idbebida;
    }

    public byte getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(byte quantidade) {
        this.quantidade = quantidade;
    }
}
