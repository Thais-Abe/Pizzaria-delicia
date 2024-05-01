package com.pizzariaDelicia.demo.services;


import com.pizzariaDelicia.demo.models.Bebida;
import com.pizzariaDelicia.demo.models.Tamanho;
import com.pizzariaDelicia.demo.models.dtos.BebidaDTO;

import com.pizzariaDelicia.demo.models.dtos.TamanhoDTO;
import com.pizzariaDelicia.demo.repositories.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TamanhoService {
    @Autowired
    private TamanhoRepository tamanhoRepository;


    public TamanhoDTO save(TamanhoDTO tamanhoDTO) {
        Tamanho tamanho = TamanhoDTO.convert(tamanhoDTO);
        tamanhoRepository.save(tamanho);
        return new TamanhoDTO(tamanho);
    }

    public TamanhoDTO updateTamanhoById(TamanhoDTO tamanhoDTO, byte id) {
       this.findTamanhoById(id);
        Tamanho tamanho = TamanhoDTO.convert(tamanhoDTO);
        return new TamanhoDTO(tamanho);
    }

    public TamanhoDTO findTamanhoById(byte id) {
        Optional<Tamanho> tamanho = tamanhoRepository.findById(id);
        if(tamanho.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }else {
            return new TamanhoDTO(tamanho.get());
        }
    }

    public String deleteTamanhoById(byte id) {
        this.tamanhoRepository.deleteById(id);
        return "tamanho deletado";
    }

    public List<TamanhoDTO> findAllTamanhos() {
        List<Tamanho> listaBebidas = this.tamanhoRepository.findAll();
        return listaBebidas.stream().map(TamanhoDTO::new).collect(Collectors.toList());
    }
}
