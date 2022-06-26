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

        setSede(new Sede("Sede AutoSell"));
        filiais.add(new Filial("Filial A"));
        filiais.add(new Filial("Filial B"));
        filiais.add(new Filial("Filial C"));
        filiais.add(new Filial("Filial D"));
        filiais.add(new Filial("Filial asd"));



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

    public LinkedList<Veiculo> getVeiculosDe(Local local) {
        if (local == null) {
            return null;
        }

        return new LinkedList<>(local.getVeiculos());
    }

    public LinkedList<Cliente> getClientes() {
        return clientes;
    }

    public LinkedList<Cliente> getCliente(String NIF) {
        //TODO
        return null;
    }

    public LinkedList<Local> getLocais() {
        LinkedList<Local> locais = new LinkedList<>(filiais);
        locais.add(sede);
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
                pecas.add(peca);

            }
        }
        return pecas;
    }
    public LinkedList<Veiculo> getVeiculos() {
        LinkedList<Veiculo> veiculos = new LinkedList<>();
        for (Local local : getLocais()) {
            for (Veiculo veiculo : local.getVeiculos()) {
                veiculos.add(veiculo);

            }
        }
        return veiculos;
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

    public void addVeiculoA(Local local, Veiculo veiculo) {
        if (local != null && veiculo != null) {
            local.addVeiculo(veiculo);
        }
    }

    public void removeVeiculoA(Local local, Veiculo veiculo) {
        if (local != null && veiculo != null) {
            local.removeVeiculo(veiculo);
        }
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

        this.sede = sede;
    }

    public void addFilial(Filial filial) {
        if (filial == null) {
            return;
        }

        filiais.add(filial);
    }

    public void removePecaA() {
    }
}
