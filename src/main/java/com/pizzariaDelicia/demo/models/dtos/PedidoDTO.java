package com.pizzariaDelicia.demo.models.dtos;

import com.pizzariaDelicia.demo.models.Cliente;
import com.pizzariaDelicia.demo.models.Fornada;
import com.pizzariaDelicia.demo.models.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class PedidoDTO {

    private long id;
    private Cliente idCliente;
    private Fornada idFornada;
    @NotBlank(message = "A data é obrigatória")
    private LocalDate dataHora;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.idCliente = pedido.getIdCliente();
        this.idFornada =pedido.getIdFornada();
        this.dataHora = pedido.getDataHora();
    }

    public static Pedido convert(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setIdCliente(new Cliente(pedidoDTO.getId()));
        pedido.setIdFornada(new Fornada(pedidoDTO.getIdFornada().getId()));
        pedido.setDataHora(pedidoDTO.getDataHora());
        return pedido;
    }


    public PedidoDTO(long id) {
        this.id = id;
    }

    public PedidoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Fornada getIdFornada() {
        return idFornada;
    }

    public void setIdFornada(Fornada idFornada) {
        this.idFornada = idFornada;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }
}
