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
    @NotBlank(message = "O tamanho deve ser preenchido")
    private Tamanho tamanho;
    @NotBlank(message = "A quantidade deve ser preenchido")
    private byte quantidade;

    public PizzaPedidaDTO(PizzaPedida pizzaPedida) {
        this.id = pizzaPedida.getId();
        this.idPedido = pizzaPedida.getPedido().getId();
        this.idPizza =  pizzaPedida.getPizza().getId();
        this.tamanho = pizzaPedida.getTamanho();
        this.quantidade = pizzaPedida.getQuantidade();
    }

    public static PizzaPedida convert(PizzaPedidaDTO pizzaPedidaDTO){
        PizzaPedida pizzaPedida = new PizzaPedida();
        pizzaPedida.setId(pizzaPedidaDTO.getId());
        pizzaPedida.setPedido(new Pedido(pizzaPedidaDTO.getIdPedido()));
        pizzaPedida.setPizza(new Pizza(pizzaPedidaDTO.getIdPizza()));
        pizzaPedida.setTamanho(new Tamanho());
        pizzaPedida.setQuantidade(pizzaPedidaDTO.getQuantidade());
        return pizzaPedida;
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

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public byte getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(byte quantidade) {
        this.quantidade = quantidade;
    }
}
