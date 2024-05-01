package com.pizzariaDelicia.demo.services;

import com.pizzariaDelicia.demo.models.Pizza;
import com.pizzariaDelicia.demo.models.PizzaPedida;
import com.pizzariaDelicia.demo.models.dtos.PizzaDTO;
import com.pizzariaDelicia.demo.models.dtos.PizzaPedidaDTO;
import com.pizzariaDelicia.demo.repositories.PizzaPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PizzaPedidaService {
    @Autowired
   private PizzaPedidoRepository pizzaPedidoRepository;
    public PizzaPedidaDTO save(PizzaPedidaDTO pizzaPedidaDTO) {
        PizzaPedida pizzaPedida = PizzaPedidaDTO.convert(pizzaPedidaDTO);
        pizzaPedida = this.pizzaPedidoRepository.save(pizzaPedida);
        return new PizzaPedidaDTO(pizzaPedida);
    }

    public PizzaPedidaDTO findOrderById(long id) {
        Optional<PizzaPedida> pizzaPedida = this.pizzaPedidoRepository.findById(id);
        if(pizzaPedida.isEmpty()){
            throw new RuntimeException("O pedido não foi encontrado");
        }else{
            return new PizzaPedidaDTO(pizzaPedida.get());
        }
    }
    public PizzaPedidaDTO updateOrderById(PizzaPedidaDTO pizzaPedidaDTO, long id) {
        this.findOrderById(id);
        PizzaPedida pizzaPedida = PizzaPedidaDTO.convert(pizzaPedidaDTO);
        return new PizzaPedidaDTO(pizzaPedida);
    }

    public PizzaPedidaDTO deleteOrderById(long id) {
        PizzaPedidaDTO pizzaPedidaDTO = this.findOrderById(id);
        this.pizzaPedidoRepository.deleteById(id);
        return pizzaPedidaDTO;
    }
}
