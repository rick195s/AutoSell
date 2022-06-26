import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Filial;
import autosell.modelo.Local;
import autosell.modelo.Veiculo;
import org.junit.Test;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class AdicionarVeiculoTeste {
    @Test
    public void TesteAdicionarVeiculo() {
        Veiculo veiculo = new Veiculo("M4", "23-XX-24", "BMW", 40000);
        Filial filial = new Filial("Filial Teste");
        filial.addVeiculo(veiculo);
        DadosDaAplicacao.INSTANCE.addFilial(filial);


        LinkedList<Local> locais = DadosDaAplicacao.INSTANCE.getLocais();
        int indexLocal = locais.indexOf(filial);

        LinkedList<Veiculo> veiculos = locais.get(indexLocal).getVeiculos();
        int indexVeiculo = veiculos.indexOf(veiculo);

        assertNotEquals(-1, indexVeiculo);
    }

    @Test
    public void TesteMatriculaInvalida() {
        Matcher matcher = Pattern.compile("\\A(\\d{2}\\-\\d{2}\\-[A-Z]{2}|\\d{2}\\-[A-Z]{2}\\-\\d{2}|[A-Z]{2}\\-\\d{2" +
                "}\\-\\d{2})\\z").matcher("x2-23-1w");

        assertFalse(matcher.find());
    }

    @Test
    public void TesteMatriculaValida() {
        Matcher matcher = Pattern.compile("\\A(\\d{2}\\-\\d{2}\\-[A-Z]{2}|\\d{2}\\-[A-Z]{2}\\-\\d{2}|[A-Z]{2}\\-\\d{2" +
                "}\\-\\d{2})\\z").matcher("23-24-XN");

        assertTrue(matcher.find());
    }
}
