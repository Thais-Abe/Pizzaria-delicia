package com.pizzariaDelicia.demo.models.dtos;


import com.pizzariaDelicia.demo.models.Cliente;
import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {

    private long id;
    @NotBlank(message = "O nome do cliente deve ser preenchido")
    private String nome;
    @NotBlank(message = "O telefone deve ser preenchido")
    private String telefone;

    @NotBlank(message = "O endereço deve ser preenchido")
    private String endereco;

    @NotBlank(message = "Digite um login")
    private String login;

    @NotBlank(message = "A quantidade de bebida deve ser preenchida")
    private String senha;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.login = cliente.getLogin();
        this.senha = cliente.getSenha();
    }

    public static Cliente convert(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setLogin(clienteDTO.getLogin());
        cliente.setSenha(clienteDTO.getSenha());
        return cliente;
    }

    public ClienteDTO(long id) {
        this.id = id;
    }

    public ClienteDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
