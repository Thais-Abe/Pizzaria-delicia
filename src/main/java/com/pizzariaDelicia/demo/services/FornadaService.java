package com.pizzariaDelicia.demo.services;

import com.pizzariaDelicia.demo.models.Fornada;
import com.pizzariaDelicia.demo.models.PizzaPedida;
import com.pizzariaDelicia.demo.models.dtos.FornadaDTO;
import com.pizzariaDelicia.demo.models.dtos.PizzaPedidaDTO;
import com.pizzariaDelicia.demo.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornadaService {
    @Autowired
    private FornadaRepository fornadaRepository;
    public FornadaDTO retornarQuantidadeDeFornadasPeloID;

    public FornadaDTO salvarFornada(FornadaDTO fornadaDTO) {
        Fornada fornada = FornadaDTO.convert(fornadaDTO);
        fornada = this.fornadaRepository.save(fornada);
        return new FornadaDTO(fornada);
    }

    public FornadaDTO modificarFornada(byte id, FornadaDTO fornadaDTO ){
        this.retornarQuantidadeDeFornadasPeloID(id);
        Fornada fornada = FornadaDTO.convert(fornadaDTO);
        return new FornadaDTO(fornada);
    }

    public String deletarFornadaPorID(byte id) {
        this.fornadaRepository.deleteById(id);
        return "Fornada deletada com sucesso";
    }

    public FornadaDTO retornarQuantidadeDeFornadasPeloID(byte id) {
        Optional<Fornada> fornada = this.fornadaRepository.findById(id);
        if(fornada.isEmpty()){
            throw new RuntimeException("O pedido não foi encontrado");
        }else{
            return new FornadaDTO(fornada.get());
        }
    }
}
