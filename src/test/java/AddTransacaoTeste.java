import autosell.modelo.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddTransacaoTeste {
    @Test
    public void TesteTransacoesOrdenadas(){
        Cliente cliente = new Cliente("Ricardo", 21321311);
        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW");
        Local local = DadosDaAplicacao.INSTANCE.getLocais().getFirst();

        Transacao transacao1 = new Transacao(
                Data.parseData("12/03/2001"),
                cliente,
                veiculo,
                local);

        Transacao transacao2 = new Transacao(
                Data.parseData("12/03/2002"),
                cliente,
                veiculo,
                local);

        DadosDaAplicacao.INSTANCE.addTransacao(transacao1);
        DadosDaAplicacao.INSTANCE.addTransacao(transacao2);

        assertEquals( Data.parseData("12/03/2002").toString(), DadosDaAplicacao.INSTANCE.getTransacoes().getFirst().getData().toString());

    }

    @Test
    public void TesteTransacaoAdicionada(){
        Cliente cliente = new Cliente("Ricardo", 21321311);
        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW");
        Local local = DadosDaAplicacao.INSTANCE.getLocais().getFirst();

        Transacao transacao1 = new Transacao(
                Data.parseData("12/03/2001"),
                cliente,
                veiculo,
                local);

        DadosDaAplicacao.INSTANCE.addTransacao(transacao1);

        assertNotEquals(-1, DadosDaAplicacao.INSTANCE.getTransacoes().indexOf(transacao1));

    }

    @Test
    public void TesteInformacaoTransacao(){
        Cliente cliente = new Cliente("Ricardo", 21321311);
        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW");
        Local local = DadosDaAplicacao.INSTANCE.getLocais().getFirst();

        Transacao transacao1 = new Transacao(
                Data.parseData("12/03/2001"),
                cliente,
                veiculo,
                local);

        DadosDaAplicacao.INSTANCE.addTransacao(transacao1);

        Transacao transacaoObtida = DadosDaAplicacao.INSTANCE.getTransacoes().getFirst();
        assertEquals(0, transacaoObtida.getData().compareTo(Data.parseData("12/03/2001")) );
        assertEquals( cliente,transacaoObtida.getCliente());
        assertEquals(local,transacaoObtida.getLocal());
        assertEquals( veiculo, transacaoObtida.getVeiculo());

    }


}
