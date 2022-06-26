import autosell.modelo.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AddClienteTeste {
    @Test
    public void TesteClienteAdicionado(){
        Cliente cliente = new Cliente("Ricardo", "21321311");
        DadosDaAplicacao.INSTANCE.addCliente(cliente);

        assertNotEquals( -1, DadosDaAplicacao.INSTANCE.getClientes().indexOf(cliente));

    }

    @Test
    public void TesteInformacoesCliente(){
        Cliente cliente = new Cliente("Guilherme", "434343232");

        DadosDaAplicacao.INSTANCE.addCliente(cliente);

        assertEquals("Guilherme" , cliente.getNome());
        assertEquals("434343232", cliente.getNIF());
    }


}
