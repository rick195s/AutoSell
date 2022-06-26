package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Filial;
import autosell.modelo.Local;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcraVerTodosLocais extends JFrame{
    private JList<Local> listTodosLocais;
    private JPanel panelLocais;
    private DefaultListModel<Local> modeloTodosLocais;

    public EcraVerTodosLocais() {
        setTitle("Todos os Locais Registados");
        setContentPane(panelLocais);
        pack();

        initComponentes();
        atualizarTodosLocais();

        listTodosLocais.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                listMouseClickActionPerformed(evt);
            }
        });
    }


    public void listMouseClickActionPerformed(MouseEvent evt){
        int botao = evt.getButton();
        if (botao == MouseEvent.BUTTON1){
            int clickCount = evt.getClickCount();
            if( clickCount == 2) {
                Local local = (Local) listTodosLocais.getSelectedValue();
                EcraVerVeiculosDeLocal.mostrarVeiculosDeLocal(this, local);
            }
        }
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
