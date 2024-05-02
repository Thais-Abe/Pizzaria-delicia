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
    public PizzaPedidaDTO salvarPedido(PizzaPedidaDTO pizzaPedidaDTO) {
        PizzaPedida pizzaPedida = PizzaPedidaDTO.convert(pizzaPedidaDTO);
        pizzaPedida = this.pizzaPedidoRepository.save(pizzaPedida);
        return new PizzaPedidaDTO(pizzaPedida);
    }

    public PizzaPedidaDTO encontrarPedidoPoID(long id) {
        Optional<PizzaPedida> pizzaPedida = this.pizzaPedidoRepository.findById(id);
        if(pizzaPedida.isEmpty()){
            throw new RuntimeException("O pedido não foi encontrado");
        }else{
            return new PizzaPedidaDTO(pizzaPedida.get());
        }
    }
    public PizzaPedidaDTO modificarPedidoPeloID(PizzaPedidaDTO pizzaPedidaDTO, long id) {
        this.encontrarPedidoPoID(id);
        PizzaPedida pizzaPedida = PizzaPedidaDTO.convert(pizzaPedidaDTO);
        return new PizzaPedidaDTO(pizzaPedida);
    }

    public PizzaPedidaDTO deletarPedido(long id) {
        PizzaPedidaDTO pizzaPedidaDTO = this.encontrarPedidoPoID(id);
        this.pizzaPedidoRepository.deleteById(id);
        return pizzaPedidaDTO;
    }
}
