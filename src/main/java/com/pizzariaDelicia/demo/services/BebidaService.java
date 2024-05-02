package com.pizzariaDelicia.demo.services;

import com.pizzariaDelicia.demo.models.Bebida;
import com.pizzariaDelicia.demo.models.dtos.BebidaDTO;
import com.pizzariaDelicia.demo.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BebidaService {
    @Autowired
    private BebidaRepository bebidaRepository;

    public List<BebidaDTO> retornarBebidas() {
        List<Bebida> listaBebidas = this.bebidaRepository.findAll();
        return listaBebidas.stream().map(BebidaDTO::new).collect(Collectors.toList());
    }

    public BebidaDTO salvar(BebidaDTO bebidaDTO) {
        Bebida bebida = BebidaDTO.convert(bebidaDTO);
        this.bebidaRepository.save(bebida);
        return new BebidaDTO(bebida);
    }

    public BebidaDTO alterarBebidaPeloID(BebidaDTO bebidaDTO, int id) {
        Optional<Bebida> bebida = this.bebidaRepository.findById(id);
        if(bebida.isEmpty()){
            throw new RuntimeException("Bebida não encontrada");
        }else{
            BebidaDTO.convert(bebidaDTO);
            return new BebidaDTO(bebida.get());
        }

    }

    public BebidaDTO deletarBebidaPorID(int id) {
        Optional<Bebida> bebida = this.bebidaRepository.findById(id);
        this.bebidaRepository.deleteById(id);
        return new BebidaDTO(bebida.get());
    }
}
