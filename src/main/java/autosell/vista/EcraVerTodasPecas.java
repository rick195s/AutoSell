package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Peca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcraVerTodasPecas extends  JFrame {
    private JPanel panelPecas;
    private JList<Peca> listTodasPecas;
    private JButton buttonVerPecasNosLocais;
    private JList<Local> listLocaisComPeca;
    private DefaultListModel<Peca> modeloTodasPecas;
    private DefaultListModel<Local> modeloPecasFiltradas;

    public EcraVerTodasPecas() {
        setTitle("Todos as Peças Registados");
        setContentPane(panelPecas);
        pack();

        initComponentes();
        atualizarTodasPecas();


        listLocaisComPeca.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                listTodosLocaisMouseClickActionPerformed(evt);
            }
        });

    }

    public void initComponentes() {
        modeloTodasPecas = new DefaultListModel<>();
        modeloPecasFiltradas = new DefaultListModel<>();
        buttonVerPecasNosLocais.addActionListener(this::buttonVerPecasNosLocaisActionPerformed);
        listLocaisComPeca.setModel(modeloPecasFiltradas);
        listTodasPecas.setModel(modeloTodasPecas);
    }

    public void atualizarTodasPecas() {
        modeloTodasPecas.removeAllElements();
        for (Peca peca : DadosDaAplicacao.INSTANCE.getPecas()) {
            modeloTodasPecas.addElement(peca);
        }

    }

    public void atualizarLocaisFiltradosPorPeca() {
        modeloPecasFiltradas.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocaisComStockDe(listTodasPecas.getSelectedValue().toString())) {
            modeloPecasFiltradas.addElement(local);
        }

    }

    public static void mostrarTodasPecas(Frame parent) {
        EcraVerTodasPecas ecraVerTodasPecas = new EcraVerTodasPecas();
        ecraVerTodasPecas.setLocationRelativeTo(parent);
        ecraVerTodasPecas.setVisible(true);
    }

    public void listTodosLocaisMouseClickActionPerformed(MouseEvent evt) {
        int botao = evt.getButton();
        if (botao == MouseEvent.BUTTON1) {
            int clickCount = evt.getClickCount();
            if (clickCount == 2) {
                if (listTodasPecas.getSelectedValue() != null && listLocaisComPeca.getSelectedValue() != null) {
                    Peca peca = (Peca) listTodasPecas.getSelectedValue();
                    Local local = (Local) listLocaisComPeca.getSelectedValue();
                    EcraTransferirPeca.mostrarTransferirPeca(this, peca, local);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione primeiro a peça e o local.");
                }
            }
        }
    }

    public void buttonVerPecasNosLocaisActionPerformed(ActionEvent evt) {
        if (listTodasPecas.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Deve Selecionar uma peça para consultar");
        } else{
            atualizarLocaisFiltradosPorPeca();

        }
    }

}


