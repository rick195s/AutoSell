import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Estatisticas {
    @Test
    public void FilialMaisVende(){
        Cliente cliente = new Cliente("Ricardo", "21321311");
        DadosDaAplicacao.INSTANCE.addCliente(cliente);

        assertNotEquals( -1, DadosDaAplicacao.INSTANCE.getClientes().indexOf(cliente));

    }

}
