import autosell.modelo.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EstatisticasTestes {
    @Test
    public void FilialMaisVende(){
        Filial filial = new Filial("Filial 1");
        Filial filial2 = new Filial("Filial 2");

        Cliente cliente = new Cliente("Ricardo", "21321311");

        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW", 299);
        Veiculo veiculo2 = new Veiculo("e1", "EW-31-TG", "BMW", 500);
        Veiculo veiculo3 = new Veiculo("r32", "EW-12-YH", "BMW", 1000);
        Veiculo veiculo4 = new Veiculo("t312", "Tr-12-YH", "BMW", 2000);
        Veiculo veiculo5 = new Veiculo("t312", "Tr-12-YH", "BMW", 2000);

        filial.addVeiculo(veiculo);
        filial.addVeiculo(veiculo2);
        filial.addVeiculo(veiculo3);
        filial.addVeiculo(veiculo4);
        filial.addVeiculo(veiculo5);

        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo2, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo3, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo4, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo5, filial));

        assertEquals(filial, Estatisticas.getFilialMaisVende());
    }

    @Test
    public void FilialMaisProfit(){
        Filial filial = new Filial("Filial 1");
        Filial filial2 = new Filial("Filial 2");

        Cliente cliente = new Cliente("Ricardo", "21321311");

        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW", 299);
        Veiculo veiculo2 = new Veiculo("e1", "EW-31-TG", "BMW", 500);
        Veiculo veiculo3 = new Veiculo("r32", "EW-12-YH", "BMW", 1000);
        Veiculo veiculo4 = new Veiculo("t312", "Tr-12-YH", "BMW", 2000);

        filial.addVeiculo(veiculo);
        filial.addVeiculo(veiculo2);
        filial.addVeiculo(veiculo3);
        filial.addVeiculo(veiculo4);

        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo2, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo3, filial));
        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo4, filial));

        DadosDaAplicacao.INSTANCE.addTransacao(new Transacao(new Data(), cliente, veiculo3, filial2));

        assertEquals(filial.toString(), Estatisticas.getFilialMaisProfit().toString());
    }
}
