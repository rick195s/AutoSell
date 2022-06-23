package autosell.modelo;

import java.util.Comparator;
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

        sede = new Sede("Sede AutoSell");
        filiais.add(new Filial("Filial A"));
        filiais.add(new Filial("Filial B"));
        filiais.add(new Filial("Filial C"));
        filiais.add(new Filial("Filial D"));
    }

    public LinkedList<Transacao> getTransacoes() {
        return transacoes;
    }

    public LinkedList<Transacao> getTransacoes(int numTransacoes) {

        ListIterator<Transacao> transacaoListIterator = transacoes.listIterator();
        LinkedList<Transacao> listaTransacoes = new LinkedList<>();

        while (transacaoListIterator.hasNext() && transacaoListIterator.nextIndex() < numTransacoes) {
            listaTransacoes.add(transacaoListIterator.next());
        }

        return listaTransacoes;

    }

    public LinkedList<Transacao> getTransacoesDe(Cliente cliente){
        //TODO
        if (cliente == null){
            return null;
        }

        LinkedList<Transacao> transacoesCliente = new LinkedList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getCliente().compareTo(cliente) == 0){
                transacoesCliente.add(transacao);
            }
        }
        return transacoesCliente;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public LinkedList<Cliente> getCliente(String nome) {
        //TODO
        return null;
    }

    public LinkedList<Local> getLocais() {
        LinkedList<Local> locais = new LinkedList<>(filiais);
        locais.add(sede);
        return locais;
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
        if (transacao == null){
            return;
        }

        transacoes.add(transacao);
        transacoes.sort(new Comparator<Transacao>() {
            @Override
            public int compare(Transacao o1, Transacao o2) {
                return o1.getData().compareTo(o2.getData());
            }
        });
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
