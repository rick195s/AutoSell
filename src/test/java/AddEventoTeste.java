import autosell.modelo.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AddEventoTeste {
    @Test
    public void TesteEventoAdicionado(){
        Evento evento = new Evento(new Local("Feira de Maio"),"Expo Baralha",new Data(20,8,2022),new Data(20,9,2022));
        DadosDaAplicacao.INSTANCE.addEvento(evento);

        assertNotEquals( -1, DadosDaAplicacao.INSTANCE.getEventos().indexOf(evento));

    }

    @Test
    public void TesteAddNovoLocal(){

        Local local = new Local("Teste Feira Novo Local");
        DadosDaAplicacao.INSTANCE.addLocal(local);
        assertNotEquals( -1, DadosDaAplicacao.INSTANCE.getLocais().indexOf(local));

    }


    @Test
    public void TesteGetEventos(){

        Local local1 = new Local("Teste Evento 1");
        Local local2 = new Local("Teste Evento 2");

        String nome1 = "Evento Nvo Feira de Maio Teste";
        String nome2 = "Event novo Feira Batalha Teste";


        Data dataIni1 = new Data(20,8,2022);
        Data dataFim1 = new Data(20,10,2022);
        Data dataIni2 = new Data(21,7,2022);
        Data dataFim2 = new Data(20,9,2022);


        Evento evento1 = new Evento(local1,nome1,dataIni1,dataFim1);
        Evento evento2 = new Evento(local2,nome2,dataIni2,dataFim2);

        DadosDaAplicacao.INSTANCE.addEvento(evento1);
        DadosDaAplicacao.INSTANCE.addEvento(evento2);

        assertEquals( "Teste Evento 1", DadosDaAplicacao.INSTANCE.getEventos().getFirst().getLocal().getNome());

    }

}
