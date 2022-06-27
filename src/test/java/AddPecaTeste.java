import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Oleo;
import autosell.modelo.Pneu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AddPecaTeste {
    @Test
    public void TesteAddPneu(){
        Pneu pneu = new Pneu("Bridgstone 2560");
        Local local = new Local("Filial TEste");
        DadosDaAplicacao.INSTANCE.addLocal(local);
        DadosDaAplicacao.INSTANCE.addPecaA(local,pneu);

        assertNotEquals( -1, DadosDaAplicacao.INSTANCE.getPecas().indexOf(pneu));

    }

    @Test
    public void TesteAddOleo(){
        Oleo oleo = new Oleo("WD-Lub-5000");
        Local local = new Local("Filial TEste Oleo");
        DadosDaAplicacao.INSTANCE.addLocal(local);
        DadosDaAplicacao.INSTANCE.addPecaA(local,oleo);

        assertNotEquals( -1, DadosDaAplicacao.INSTANCE.getPecas().indexOf(oleo));

    }
}
