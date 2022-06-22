package autosell.modelo;

import java.util.Date;

public class Transacao {
    private Date data;
    private String tipo;
    private Cliente cliente;
    private Veiculo veiculo;
    private Local local;

    public Transacao(Date data, String tipo, Cliente cliente, Veiculo veiculo, Local local) {
        this.data = data;
        this.tipo = tipo;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Local getLocal() {
        return local;
    }
}
