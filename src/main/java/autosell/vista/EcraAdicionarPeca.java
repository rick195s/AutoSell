package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Peca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraAdicionarPeca extends JFrame {

    private JComboBox<Local> cbLocalARetirarPeca;
    private JComboBox<Peca> cbEscolherPeca;
    private JButton buttonAdicionarPeca;
    private JButton buttonCancelar;
    private JPanel panelAdicionarPeca;
    private JComboBox<Local> cbLocalAAdionarPeca;

    private DefaultComboBoxModel<Local> modalLocais;
    private DefaultComboBoxModel<Peca> modalPecas;
    private DefaultComboBoxModel<Local> modalLocaisCBLocalAdicionarPeca;

    public EcraAdicionarPeca() {
        setTitle("Adicionar Peça");
        setContentPane(panelAdicionarPeca);
        pack();

        initComponentes();
        atualizarTodosLocais();
    }

    public void initComponentes() {
        modalLocais = new DefaultComboBoxModel<>();
        modalPecas = new DefaultComboBoxModel<>();
        modalLocaisCBLocalAdicionarPeca = new DefaultComboBoxModel<>();
        cbLocalARetirarPeca.setModel(modalLocais);
        cbEscolherPeca.setModel(modalPecas);
        cbLocalAAdionarPeca.setModel(modalLocaisCBLocalAdicionarPeca);

        buttonAdicionarPeca.addActionListener(this::btnAdicionarPecaActionPerformed);
        buttonCancelar.addActionListener(this::btnCancelarActionPerformed);
        cbLocalARetirarPeca.addActionListener(this::atualizarCBPecaActionPerformed);
    }

    public static void adicionarPeca(Frame parent) {
        EcraAdicionarPeca ecraAdicionarPeca = new EcraAdicionarPeca();
        ecraAdicionarPeca.setLocationRelativeTo(parent);
        ecraAdicionarPeca.setVisible(true);
    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    public void btnAdicionarPecaActionPerformed(ActionEvent evt) {
        if (cbLocalARetirarPeca.getSelectedItem() == null) {
            return;
        }
        if (cbEscolherPeca.getSelectedItem() == null) {
            return;
        }
        if (cbLocalAAdionarPeca.getSelectedItem() == null) {
            return;
        }

        DadosDaAplicacao.INSTANCE.addPecaA((Local) cbLocalAAdionarPeca.getSelectedItem(), (Peca) cbEscolherPeca.getSelectedItem());
        DadosDaAplicacao.INSTANCE.removePecaA((Local) cbLocalARetirarPeca.getSelectedItem(), (Peca) cbEscolherPeca.getSelectedItem());
        JOptionPane.showMessageDialog(null, "Adicionada peça com sucesso!");
        modalLocais.removeAllElements();
        modalPecas.removeAllElements();
        modalLocaisCBLocalAdicionarPeca.removeAllElements();
        atualizarTodosLocais();
    }

    public void atualizarCBPecaActionPerformed(ActionEvent evt) {
        modalPecas.removeAllElements();
        Object selectedItem = cbLocalARetirarPeca.getSelectedItem();
        if (selectedItem instanceof Local) {
            modalPecas.addAll(((Local) selectedItem).getPecas());
            atualizarCBLocalAdicionarPeca(selectedItem);
        }
    }

    public void atualizarCBLocalAdicionarPeca(Object selectedItem) {
        modalLocaisCBLocalAdicionarPeca.removeAllElements();
        modalLocaisCBLocalAdicionarPeca.addAll(DadosDaAplicacao.INSTANCE.getLocais());
        modalLocaisCBLocalAdicionarPeca.removeElement(selectedItem);
    }

    public void atualizarTodosLocais() {
        modalLocais.removeAllElements();
        modalLocais.addAll(DadosDaAplicacao.INSTANCE.getLocais());
    }

    private void fechar() {
        dispose();
    }
}
