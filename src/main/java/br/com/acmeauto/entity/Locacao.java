package br.com.acmeauto.entity;

import br.com.acmeauto.dto.LocacaoRequestDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "TB_LOCACAO")
public class Locacao {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "automovel_placa", referencedColumnName = "placa")
    private Automovel automovel;

    @Column(name = "valor", nullable = false, unique = false)
    private double valor;

    @Column(name = "dias", nullable = false, unique = false)
    private Integer dias;

    public Locacao() {
    }

    public Locacao(String id, Cliente cliente, Automovel automovel, double valor, Integer dias) {
        this.id = id;
        this.cliente = cliente;
        this.automovel = automovel;
        this.valor = valor;
        this.dias = dias;
    }

    public Locacao(LocacaoRequestDTO locacaoRequestDTO) {
        this.cliente = new Cliente(locacaoRequestDTO.getCliente());
        this.automovel = new Automovel(locacaoRequestDTO.getAutomovel());
        this.valor = locacaoRequestDTO.getValor();
        this.dias = locacaoRequestDTO.getDias();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
}
