package br.com.acmeauto.dto;

public class LocacaoRequestDTO {

    private ClienteDTO cliente;
    private AutomovelDTO automovel;
    private Integer dias;
    private double valor;

    public LocacaoRequestDTO() {
    }

    public LocacaoRequestDTO(ClienteDTO cliente, AutomovelDTO automovel, Integer dias, double valor) {
        this.cliente = cliente;
        this.automovel = automovel;
        this.dias = dias;
        this.valor = valor;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public AutomovelDTO getAutomovel() {
        return automovel;
    }

    public void setAutomovel(AutomovelDTO automovel) {
        this.automovel = automovel;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
