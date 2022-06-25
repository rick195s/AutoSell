package autosell.modelo;

import java.util.ArrayList;
import java.util.HashMap;

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
}
