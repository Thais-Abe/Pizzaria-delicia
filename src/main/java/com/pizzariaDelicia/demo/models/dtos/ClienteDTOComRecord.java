package com.pizzariaDelicia.demo.models.dtos;

public record ClienteDTOComRecord(String nome, String telefone, String endereco, String login,
                                  String senha) {

    public ClienteDTOComRecord(String nome, String telefone, String endereco, String login,
                               String senha){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
    }

    public String nome(){
        return  this.nome;
    }
    public String telefone(){
        return  this.telefone;
    }
    public String endereco(){
        return this.endereco;
    }
    public String login(){
        return this.login;
    }
    public String senha(){
        return this.senha;
    }

}
