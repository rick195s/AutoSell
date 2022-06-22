package autosell.modelo;

import java.util.LinkedList;
import java.util.ListIterator;

public class DadosDaAplicacao {
    public static DadosDaAplicacao INSTANCE = new DadosDaAplicacao();

    private LinkedList<Transacao> transacoes;
    private LinkedList<Filial> filiais;
    private Sede sede;
    private LinkedList<Cliente> clientes;
    private LinkedList<Evento> eventos;

    private DadosDaAplicacao() {
        transacoes = new LinkedList<>();
        filiais = new LinkedList<>();
        clientes = new LinkedList<>();
        eventos = new LinkedList<>();
    }

    public LinkedList<Transacao> getTransacoes(int numTransacoes) {
        //TODO
        /*ListIterator<Transacao> transacaoListIterator = transacoes.listIterator();
        LinkedList<Transacao> listaTransacoes = new LinkedList<>();

        while (transacaoListIterator.hasNext() && transacaoListIterator.nextIndex() < numTransacoes) {
            listaTransacoes.add(transacaoListIterator.next());
        }

        return listaTransacoes;*/
        return null;
    }

    public LinkedList<Transacao> getTransacoesDe(Cliente cliente){
        //TODO

        return null;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public LinkedList<Cliente> getCliente(String nome) {
        //TODO
        return null;
    }

    public LinkedList<Local> getLocais() {
        //TODO
        return null;
    }

    public LinkedList<Local> getLocaisComStockDe(String nomePeca) {
        //TODO
        return null;
    }

    public LinkedList<Peca> getPecas() {
        //TODO
        return null;
    }

    public void addCliente(Cliente cliente){
        if (cliente == null){
            return;
        }

        clientes.add(cliente);
    }

    public void addEvento(Evento evento){
        if (evento == null){
            return;
        }

        eventos.add(evento);
    }

    public void addVeiculoA(Local local, Veiculo veiculo){
        //TODO
    }

    public void addPecaA(Local local, Peca peca){
        //TODO
    }

    public void addTransacao(Transacao transacao){
        //TODO
    }

    public void setSede(Sede sede) {
        if (sede == null){
            return;
        }

        this.sede = sede;
    }

    public void addFilial(Filial filial){
        if (filial == null){
            return;
        }

        filiais.add(filial);
    }
}
