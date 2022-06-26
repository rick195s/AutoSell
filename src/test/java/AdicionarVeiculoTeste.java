import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Filial;
import autosell.modelo.Veiculo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AdicionarVeiculoTeste {
    //TODO
    @Test
    public void TesteAdicionarVeiculo() {
        Filial filial = new Filial("Leiria");
        Veiculo veiculo = new Veiculo("M4", "23-XX-24", "BMW", 40000);
        filial.addVeiculo(veiculo);
        DadosDaAplicacao.INSTANCE.addFilial(filial);

        assertEquals("23-XX-24", DadosDaAplicacao.INSTANCE.getLocais().indexOf(filial));
    }
}
