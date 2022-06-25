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
}
