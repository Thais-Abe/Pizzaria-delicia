package com.pizzariaDelicia.demo.controllers;

import com.pizzariaDelicia.demo.models.dtos.BebidaDTO;
import com.pizzariaDelicia.demo.models.dtos.IngredienteDTO;
import com.pizzariaDelicia.demo.models.dtos.PizzaPedidaDTO;
import com.pizzariaDelicia.demo.services.BebidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;
    @GetMapping
    public List<BebidaDTO> findDrinkById(){
        return this.bebidaService.findAllDrinks();
    }
    @PostMapping
    public BebidaDTO save(@RequestBody @Valid BebidaDTO bebidaDTO){
        return this.bebidaService.save(bebidaDTO);
    }

    @PutMapping("/{id}")
    public BebidaDTO updateDrinkById(@RequestBody BebidaDTO bebidaDTO, @PathVariable int id){
        return  this.bebidaService.updateDrinkById(bebidaDTO, id);
    }

    @DeleteMapping("/{id}")
    public BebidaDTO deleteDrinkById(@PathVariable int id){
        return  this.bebidaService.deleteDrinkById(id);
    }

}
