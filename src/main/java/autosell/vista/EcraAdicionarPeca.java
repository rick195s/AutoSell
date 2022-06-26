package autosell.vista;

import autosell.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraAdicionarPeca extends JFrame{
    private JComboBox cbTipoPeca;
    private JTextField txtNomePeca;
    private JComboBox cbLocalAdicionarPeca;
    private JButton btnAdicionarPeca;
    private JButton btnCancelar;
    private JPanel panelAdicionarPeca;

    private DefaultComboBoxModel<Local> modalLocais;

    public EcraAdicionarPeca() {
        setTitle("Adicionar Peça");
        setContentPane(panelAdicionarPeca);
        pack();

        initComponentes();
        atualizarLocais();
    }

    public static void mostrarAdicionarPeca(Frame parent) {
        EcraAdicionarPeca ecraAdicionarPeca = new EcraAdicionarPeca();
        ecraAdicionarPeca.setLocationRelativeTo(parent);
        ecraAdicionarPeca.setVisible(true);
    }

    public void initComponentes() {
        modalLocais = new DefaultComboBoxModel<>();

        cbLocalAdicionarPeca.setModel(modalLocais);

        btnAdicionarPeca.addActionListener(this::btnAdicionarPecaActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    public void atualizarLocais() {
        modalLocais.removeAllElements();
        modalLocais.addAll(DadosDaAplicacao.INSTANCE.getLocais());
    }

    public void btnAdicionarPecaActionPerformed(ActionEvent evt) {
        if (cbTipoPeca.getSelectedIndex() == 0) { // opcao Oleo
            if (cbLocalAdicionarPeca.getSelectedItem() != null) {
                DadosDaAplicacao.INSTANCE.addPecaA(((Local)cbLocalAdicionarPeca.getSelectedItem()),
                        new Oleo(txtNomePeca.getText()));
                JOptionPane.showMessageDialog(null, "Peça adicionada com sucesso");
                fechar();
            }
        }
        if (cbTipoPeca.getSelectedIndex() == 1) { //opcao pneu
            if (cbLocalAdicionarPeca.getSelectedItem() != null) {
                DadosDaAplicacao.INSTANCE.addPecaA(((Local)cbLocalAdicionarPeca.getSelectedItem()),
                        new Pneu(txtNomePeca.getText()));
                JOptionPane.showMessageDialog(null, "Peça adicionada com sucesso");
                fechar();
            }
        }
    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        dispose();
    }
}
