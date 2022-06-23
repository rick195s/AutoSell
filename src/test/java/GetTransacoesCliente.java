import autosell.modelo.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetTransacoesCliente {
    @Test
    public void TesteTransacoesCliente(){

        Cliente cliente = new Cliente("Ricardo", "21321311");
        Cliente cliente2 = new Cliente("Guilherme", "754421542");
        Veiculo veiculo = new Veiculo("M1", "AD-Dw-12", "BMW", 299);
        Local local = DadosDaAplicacao.INSTANCE.getLocais().getFirst();

        Transacao transacao1 = new Transacao(
                Data.parseData("12/03/2001"),
                cliente,
                veiculo,
                local);

        Transacao transacao2 = new Transacao(
                Data.parseData("12/03/2002"),
                cliente2,
                veiculo,
                local);

        DadosDaAplicacao.INSTANCE.addTransacao(transacao1);
        DadosDaAplicacao.INSTANCE.addTransacao(transacao2);

        assertEquals( "Ricardo", DadosDaAplicacao.INSTANCE.getTransacoesDe(cliente).getFirst().getCliente().getNome());

    }
}
