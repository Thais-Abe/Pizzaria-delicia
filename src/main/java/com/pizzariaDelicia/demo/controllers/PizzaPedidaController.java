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
    public PizzaPedidaDTO findOrderById(@PathVariable long id){
        return this.pizzaPedidaService.findOrderById(id);
    }
    @PostMapping
    public PizzaPedidaDTO save(@RequestBody PizzaPedidaDTO pizzaPedidaDTO){
        return this.pizzaPedidaService.save(pizzaPedidaDTO);
    }
    @PutMapping("/{id}")
    public PizzaPedidaDTO updateOrderById(@RequestBody PizzaPedidaDTO pizzaPedidaDTO, int id){
        return  this.pizzaPedidaService.updateOrderById(pizzaPedidaDTO, id);
    }

    @DeleteMapping("/{id}")
    public PizzaPedidaDTO deleteOrderById(long id){
        return  this.pizzaPedidaService.deleteOrderById(id);
    }


}
