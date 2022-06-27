import autosell.modelo.*;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TransferPecaTeste {
    @Test
    public void TesteTransferirPeca() {
        Filial filial = new Filial("Filial D");
        Filial filial2 = new Filial("Filial E");

        Oleo oleo = new Oleo("WD405");
        filial.addPeca(oleo);

        DadosDaAplicacao.INSTANCE.addPecaA(filial2, oleo);
        DadosDaAplicacao.INSTANCE.removePecaA(filial, oleo);

        LinkedList<Local> locais = DadosDaAplicacao.INSTANCE.getLocais();
        int indexLocal = locais.indexOf(filial2);

        LinkedList<Peca> pecas = locais.get(indexLocal).getPecas();
        int indexPeca = pecas.indexOf(oleo);

        assertNotEquals(-1, indexPeca);
    }

    @Test
    public void TesteInformacaoPeca() {
        Filial filial = new Filial("Filial D");
        Filial filial2 = new Filial("Filial E");

        Oleo oleo = new Oleo("WD405");
        filial.addPeca(oleo);
        DadosDaAplicacao.INSTANCE.addPecaA(filial2, oleo);
        DadosDaAplicacao.INSTANCE.removePecaA(filial, oleo);

        LinkedList<Local> locais = DadosDaAplicacao.INSTANCE.getLocais();
        int indexLocal = locais.indexOf(filial2);
        int indexLocalRetirar = locais.indexOf(filial);

        LinkedList<Peca> pecas = locais.get(indexLocal).getPecas();
        int indexPeca = pecas.indexOf(oleo);

        LinkedList<Peca> pecasLocal = locais.get(indexLocalRetirar).getPecas();
        int indexPecaRetiradaLocal = pecasLocal.indexOf(oleo);

        assertNotEquals(-1, indexPeca);
        assertEquals(-1, indexPecaRetiradaLocal);
    }
}
