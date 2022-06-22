package autosell.modelo;

public class Transacao {
    private Data data;
    private Cliente cliente;
    private Veiculo veiculo;
    private Local local;

    public Transacao(Data data, String tipo, Cliente cliente, Veiculo veiculo, Local local) {
        this.data = data;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.local = local;
    }

    public Data getData() {
        return data;
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
