package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Peca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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



        buttonVerPecasNosLocais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listTodasPecas.getSelectedValue()==null){
                    JOptionPane.showMessageDialog(null,"Deve Selecionar uma peça para consultar");
                }else
                    atualizarLocaisFiltradosPorPeca();
                System.out.println(listTodasPecas.getSelectedValue());
            }
        });
    }
    public void initComponentes() {
        modeloTodasPecas = new DefaultListModel<>();
        modeloPecasFiltradas = new DefaultListModel<>();
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
}


