package autosell.modelo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DadosDaAplicacao {
    public static DadosDaAplicacao INSTANCE = new DadosDaAplicacao();

    private LinkedList<Transacao> transacoes;
    private Sede sede;
    private LinkedList<Cliente> clientes;
    private LinkedList<Evento> eventos;
    private LinkedList<Local> locais;



    private DadosDaAplicacao() {
        transacoes = new LinkedList<>();
        clientes = new LinkedList<>();
        eventos = new LinkedList<>();
        locais = new LinkedList<>();

        setSede(new Sede("Sede AutoSell"));
        locais.add(new Filial("Filial A"));
        locais.add(new Filial("Filial B"));
        locais.add(new Filial("Filial C"));
        locais.add(new Filial("Filial D"));
        locais.add(new Filial("Filial asd"));

        Cliente cliente = new Cliente("Ricardo", "21321311");
        Cliente cliente2 = new Cliente("Ricardo", "21321312");
        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW", 299);
        Veiculo veiculo2 = new Veiculo("e1", "EW-31-TG", "BMW", 500);

        Local local = getLocais().getFirst();
        Local local2 = getLocais().getLast();
        Local local3 = getLocais().get(2);

        Oleo oleo1 = new Oleo("wd40");
        Oleo oleo2 = new Oleo("wd50");
        Oleo oleo3 = new Oleo("wd50adsadasd");
        Pneu pneu1 = new Pneu("Continental");
        Pneu pneu2 = new Pneu("Michelin");

        local.addPeca(oleo1);
        local.addPeca(pneu1);
        local2.addPeca(oleo2);
        local2.addPeca(pneu2);
        local3.addPeca(oleo3);
        local2.addPeca(oleo3);

        sede.addVeiculo(veiculo);
        sede.addVeiculo(veiculo2);
        local.addVeiculo(veiculo);
        local3.addVeiculo(veiculo2);
        getLocais().get(2).addVeiculo(veiculo2);

        clientes.add(cliente);
        clientes.add(cliente2);

        transacoes.add(new Transacao(
                Data.parseData("12/03/2001"),
                cliente,
                veiculo,
                local)
        );
    }

    public Sede getSede() {
        return sede;
    }

    public LinkedList<Transacao> getTransacoes() {
        return transacoes;
    }
    public LinkedList<Evento> getEventos() {
        return eventos;
    }
    public LinkedList<Transacao> getTransacoes(int numTransacoes) {

        ListIterator<Transacao> transacaoListIterator = transacoes.listIterator();
        LinkedList<Transacao> listaTransacoes = new LinkedList<>();

        while (transacaoListIterator.hasNext() && transacaoListIterator.nextIndex() < numTransacoes) {
            listaTransacoes.add(transacaoListIterator.next());
        }

        return listaTransacoes;

    }

    public LinkedList<Transacao> getTransacoesDe(Cliente cliente) {
        if (cliente == null) {
            return null;
        }

        LinkedList<Transacao> transacoesCliente = new LinkedList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getCliente().compareTo(cliente) == 0) {
                transacoesCliente.add(transacao);
            }
        }
        return transacoesCliente;
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }


    public LinkedList<Local> getLocais() {
        LinkedList<Local> locais = new LinkedList<>(this.locais);
        locais.add(getSede());
        return locais;
    }

    public LinkedList<Local> getLocaisComStockDe(String nomePeca) {
        LinkedList<Local> locais = new LinkedList<>();
        for (Local local : getLocais()) {
            if (local.pecaEmStock(nomePeca)){
                locais.add(local);
            }
        }
        return locais;
    }

    public LinkedList<Peca> getPecas() {
        LinkedList<Peca> pecas = new LinkedList<>();
        for (Local local : getLocais()) {
            for (Peca peca : local.getPecas()) {
                if (!pecas.contains(peca)) {
                    pecas.add(peca);
                }
            }
        }
        return pecas;
    }

    public void addCliente(Cliente cliente) {
        if (cliente == null) {
            return;
        }

        clientes.add(cliente);
    }

    public void addEvento(Evento evento) {
        if (evento == null) {
            return;
        }

        eventos.add(evento);
    }

    public void addPecaA(Local local, Peca peca) {
        if (local != null && peca != null) {
            local.addPeca(peca);
        }
    }

    public void removePecaA(Local local, Peca peca) {
        if (local != null && peca != null) {
            local.removePeca(peca);
        }
    }


    public void addTransacao(Transacao transacao) {
        if (transacao == null) {
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
        if (sede == null) {
            return;
        }

        if (this.sede != null) {
            this.locais.remove(this.sede);
        }

        this.sede = sede;
    }

    public void addLocal(Local local) {
        if (local == null) {
            return;
        }

        if (local instanceof Sede) {
            setSede((Sede) local);
        }

        locais.add(local);
    }

}
