package br.com.acmeauto.dto;

import br.com.acmeauto.entity.Automovel;

public class AutomovelDTO {

    private String placa;
    private String marca;
    private String modelo;
    private Integer ano;
    private double valorDiaria;
    private boolean disponivel;

    public AutomovelDTO() {
    }

    public AutomovelDTO(String placa, String marca, String modelo, Integer ano, double valorDiaria, boolean disponivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public AutomovelDTO(Automovel automovel) {
        this.placa = automovel.getPlaca();
        this.marca = automovel.getMarca();
        this.modelo = automovel.getModelo();
        this.ano = automovel.getAno();
        this.valorDiaria = automovel.getValorDiaria();
        this.disponivel = automovel.isDisponivel();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
