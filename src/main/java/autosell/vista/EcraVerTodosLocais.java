package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Filial;
import autosell.modelo.Local;

import javax.swing.*;
import java.awt.*;

public class EcraVerTodosLocais extends JFrame{
    private JList listTodosLocais;
    private JPanel panelLocais;
    private JComboBox cbTipoLocal; //TODO - selecionar tipo de local -
    private DefaultListModel<Local> modeloTodosLocais;

    public EcraVerTodosLocais() {
        setTitle("Todos os Locais Registados");
        setContentPane(panelLocais);
        pack();

        initComponentes();
        atualizarTodosLocais();

        //listTodosLocais.addMouseListener();
    }

    public static void mostrarTodosLocais(Frame parent) {
        EcraVerTodosLocais ecraVerTodosLocais = new EcraVerTodosLocais();
        ecraVerTodosLocais.setLocationRelativeTo(parent);
        ecraVerTodosLocais.setVisible(true);
    }

    public void initComponentes() {
        modeloTodosLocais = new DefaultListModel<>();
        listTodosLocais.setModel(modeloTodosLocais);
    }

    public void atualizarTodosLocais() {
        modeloTodosLocais.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            modeloTodosLocais.addElement(local);
        }
    }
}
