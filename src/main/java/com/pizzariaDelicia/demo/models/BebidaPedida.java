package com.pizzariaDelicia.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "bebidaPedida")
public class BebidaPedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido idpedido;
    @ManyToOne
    @JoinColumn(name = "idBebida")
    private Bebida idbebida;
    @Column(nullable = false)
    private byte quantidade;


    public BebidaPedida() {
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
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
