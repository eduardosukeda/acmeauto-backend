package br.com.acmeauto.entity;

import br.com.acmeauto.dto.AutomovelDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AUTOMOVEL")
public class Automovel {

    @Id
    private String placa;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "valorDiaria", nullable = false)
    private double valorDiaria;

    @Column(name = "disponivel", nullable = false)
    private boolean disponivel;

    public Automovel() {
    }

    public Automovel(String placa, String marca, String modelo, Integer ano, double valorDiaria, boolean disponivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.disponivel = disponivel;
    }

    public Automovel(AutomovelDTO automovelDTO) {
        this.placa = automovelDTO.getPlaca();
        this.marca = automovelDTO.getMarca();
        this.modelo = automovelDTO.getModelo();
        this.ano = automovelDTO.getAno();
        this.valorDiaria = automovelDTO.getValorDiaria();
        this.disponivel = automovelDTO.isDisponivel();
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
