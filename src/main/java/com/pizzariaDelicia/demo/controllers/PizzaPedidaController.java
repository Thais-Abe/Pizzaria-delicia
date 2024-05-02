package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.PizzaDTO;
import com.pizzariaDelicia.demo.models.dtos.PizzaPedidaDTO;
import com.pizzariaDelicia.demo.services.PizzaPedidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PizzaPedidaController {

    @Autowired
    private PizzaPedidaService pizzaPedidaService;

    @GetMapping("/{id}")
    public PizzaPedidaDTO encontrarPedidoPoID(@PathVariable long id){
        return this.pizzaPedidaService.encontrarPedidoPoID(id);
    }
    @PostMapping
    public PizzaPedidaDTO salvarPedido(@RequestBody PizzaPedidaDTO pizzaPedidaDTO){
        return this.pizzaPedidaService.salvarPedido(pizzaPedidaDTO);
    }
    @PutMapping("/{id}")
    public PizzaPedidaDTO modificarPedidoPeloID(@RequestBody PizzaPedidaDTO pizzaPedidaDTO, int id){
        return  this.pizzaPedidaService.modificarPedidoPeloID(pizzaPedidaDTO, id);
    }

    @DeleteMapping("/{id}")
    public PizzaPedidaDTO deletarPedido(long id){
        return  this.pizzaPedidaService.deletarPedido(id);
    }


}
