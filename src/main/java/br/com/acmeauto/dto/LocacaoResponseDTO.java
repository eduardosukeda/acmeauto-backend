package br.com.acmeauto.dto;

import br.com.acmeauto.entity.Locacao;

public class LocacaoResponseDTO {

    private ClienteDTO clienteDTO;
    private AutomovelDTO automovelDTO;
    private Integer dias;
    private double valor;

    public LocacaoResponseDTO() {
    }

    public LocacaoResponseDTO(ClienteDTO clienteDTO, AutomovelDTO automovelDTO, Integer dias, double valor) {
        this.clienteDTO = clienteDTO;
        this.automovelDTO = automovelDTO;
        this.dias = dias;
        this.valor = valor;
    }

    public LocacaoResponseDTO(Locacao locacao) {
        this.clienteDTO = new ClienteDTO(locacao.getCliente());
        this.automovelDTO = new AutomovelDTO(locacao.getAutomovel());
        this.dias = locacao.getDias();
        this.valor = locacao.getValor();
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public AutomovelDTO getAutomovelDTO() {
        return automovelDTO;
    }

    public void setAutomovelDTO(AutomovelDTO automovelDTO) {
        this.automovelDTO = automovelDTO;
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
