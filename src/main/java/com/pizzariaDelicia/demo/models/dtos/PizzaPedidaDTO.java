package com.pizzariaDelicia.demo.models.dtos;

import com.pizzariaDelicia.demo.models.Pedido;
import com.pizzariaDelicia.demo.models.Pizza;
import com.pizzariaDelicia.demo.models.PizzaPedida;
import com.pizzariaDelicia.demo.models.Tamanho;
import jakarta.validation.constraints.NotBlank;

public class PizzaPedidaDTO {
    private long id;
    private long idPedido;

    private int idPizza;

    private byte idTamanho;

    private byte quantidade;

    public PizzaPedidaDTO(PizzaPedida pizzaPedida) {
        this.id = pizzaPedida.getId();
        this.idPedido = pizzaPedida.getPedido().getId();
        this.idPizza =  pizzaPedida.getPizza().getId();
        this.idTamanho = pizzaPedida.getTamanho().getId();
        this.quantidade = pizzaPedida.getQuantidade();
    }

    public static PizzaPedida convert(PizzaPedidaDTO pizzaPedidaDTO){
        PizzaPedida pizzaPedida = new PizzaPedida();
        pizzaPedida.setId(pizzaPedidaDTO.getId());
        pizzaPedida.setPedido(new Pedido(pizzaPedidaDTO.getIdPedido()));
        pizzaPedida.setPizza(new Pizza(pizzaPedidaDTO.getIdPizza()));
        pizzaPedida.setTamanho(new Tamanho(pizzaPedidaDTO.getTamanho()));
        pizzaPedida.setQuantidade(pizzaPedidaDTO.getQuantidade());
        return pizzaPedida;
    }

    public PizzaPedidaDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public byte getTamanho() {
        return idTamanho;
    }

    public void setTamanho(byte tamanho) {
        this.idTamanho = tamanho;
    }

    public byte getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(byte quantidade) {
        this.quantidade = quantidade;
    }
}
