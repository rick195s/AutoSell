package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Veiculo;

import javax.swing.*;
import java.awt.*;

public class EcraVerVeiculosDeLocal extends JDialog{
    private JList listVeiculosLocal;
    private JPanel panelVeiculosDeLocal;
    private DefaultListModel<Veiculo> modalVeiculos;

    public EcraVerVeiculosDeLocal(Frame parent, boolean modal, Local local) {
        super(parent,modal);
        setTitle("Detalhes do Cliente");
        setContentPane(panelVeiculosDeLocal);
        pack();

        initComponentes();
        atualizarVeiculos(local);
    }

    public void initComponentes() {
        modalVeiculos = new DefaultListModel<>();
        listVeiculosLocal.setModel(modalVeiculos);
    }

    public static void mostrarVeiculosDeLocal(Frame parent, Local local) {
        EcraVerVeiculosDeLocal ecraVerVeiculosDeLocal = new EcraVerVeiculosDeLocal(parent, true, local);
        ecraVerVeiculosDeLocal.setLocationRelativeTo(parent);
        ecraVerVeiculosDeLocal.setVisible(true);
    }

    public void atualizarVeiculos(Local local) {
        modalVeiculos.removeAllElements();
        modalVeiculos.addAll(DadosDaAplicacao.INSTANCE.getVeiculosDe(local));
    }
}
