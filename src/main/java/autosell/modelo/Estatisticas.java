package autosell.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Estatisticas {

    public static Filial getFilialMaisVende(){
        HashMap<Filial, Integer> hashMap = new HashMap<>();

        Filial filialMaisVende = new Filial("");

        for (Transacao transacao : DadosDaAplicacao.INSTANCE.getTransacoes()) {
            Local local = transacao.getLocal();
            if (local instanceof Filial){

                Integer numTransacoes = hashMap.getOrDefault(local, 0);

                hashMap.put((Filial) local, numTransacoes +1);

                if (hashMap.getOrDefault(filialMaisVende,0) < numTransacoes+1) {
                    filialMaisVende = (Filial) local;
                }
            }
        }

        return filialMaisVende;
    }

    public static Filial getFilialMaisProfit(){
        HashMap<Filial, Double> hashMap = new HashMap<>();

        Filial filialMaisProfit = new Filial("");

        for (Transacao transacao : DadosDaAplicacao.INSTANCE.getTransacoes()) {
            Local local = transacao.getLocal();
            if (local instanceof Filial){

                Double profit = hashMap.getOrDefault(local, 0.0);

                hashMap.put((Filial) local, profit + transacao.getValor());

                if (hashMap.getOrDefault(filialMaisProfit,0.0) < profit + transacao.getValor()) {
                    filialMaisProfit = (Filial) local;
                }


            }
        }

        return filialMaisProfit;
    }

    public static double profitSede(){
        double profit = 0.0;

        for (Transacao transacao : DadosDaAplicacao.INSTANCE.getTransacoes()) {
            if (transacao.getLocal() == DadosDaAplicacao.INSTANCE.getSede()){
                profit+=transacao.getValor();
            }
        }

        return profit;
    }


    public static int getNumCarrosVendidos(){
        return DadosDaAplicacao.INSTANCE.getTransacoes().size();

    }

    public static int getNumPneusStock() {
        int numPneus = 0;

        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            for (Peca peca : local.getPecas()) {
                if (peca instanceof Pneu){
                    numPneus++;
                }
            }
        }

        return numPneus;
    }

    public static int getNumCarrosStock() {
        int numCarrosStock = 0;

        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            numCarrosStock+=local.getVeiculos().size();
        }

        return numCarrosStock;
    }

    public static Cliente getMelhorCliente() {

        HashMap<Cliente, Integer> hashMap = new HashMap<>();

        LinkedList<Cliente> clientes = DadosDaAplicacao.INSTANCE.getClientes();

        if (clientes == null) {
            return null;
        }

        Cliente melhorCliente = clientes.getFirst();

        for (Transacao transacao : DadosDaAplicacao.INSTANCE.getTransacoes()) {
            Cliente cliente = transacao.getCliente();
                Integer numTransacoes = hashMap.getOrDefault(cliente, 0);

                hashMap.put(cliente, numTransacoes +1);

                if (hashMap.getOrDefault(melhorCliente,0) < numTransacoes+1) {
                    melhorCliente = cliente;
            }
        }

        return melhorCliente;
    }
}
