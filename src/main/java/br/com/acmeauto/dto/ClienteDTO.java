package br.com.acmeauto.dto;

import br.com.acmeauto.entity.Cliente;

public class ClienteDTO {

    private String cpf;
    private String nome;

    public ClienteDTO() {
    }

    public ClienteDTO(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public ClienteDTO(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
