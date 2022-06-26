package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Peca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraTransferirPeca extends JFrame {

    private JComboBox<Local> cbLocalARetirarPeca;
    private JComboBox<Peca> cbEscolherPeca;
    private JButton buttonAdicionarPeca;
    private JButton buttonCancelar;
    private JPanel panelAdicionarPeca;
    private JComboBox<Local> cbLocalAAdionarPeca;

//    private DefaultComboBoxModel<Local> modalLocais;
//    private DefaultComboBoxModel<Peca> modalPecas;
    private DefaultComboBoxModel<Local> modalLocaisCBLocalAdicionarPeca;

    public EcraTransferirPeca(Frame parent, Peca peca, Local local) {
        setTitle("Transferir Peça");
        setContentPane(panelAdicionarPeca);
        pack();

        cbEscolherPeca.setEnabled(false);
        cbLocalARetirarPeca.setEnabled(false);

        initComponentes(peca, local);
        atualizarCBLocalAdicionarPeca(local);
    }

    public void initComponentes(Peca peca, Local local) {
        modalLocaisCBLocalAdicionarPeca = new DefaultComboBoxModel<>();
        cbLocalARetirarPeca.addItem(local);
        cbEscolherPeca.addItem(peca);
        cbLocalAAdionarPeca.setModel(modalLocaisCBLocalAdicionarPeca);


        buttonAdicionarPeca.addActionListener(this::btnAdicionarPecaActionPerformed);
        buttonCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    public static void mostrarTransferirPeca(Frame parent, Peca peca, Local local) {
        EcraTransferirPeca ecraTransferirPeca = new EcraTransferirPeca(parent, peca, local);
        ecraTransferirPeca.setLocationRelativeTo(parent);
        ecraTransferirPeca.setVisible(true);
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
        fechar();
    }


    public void atualizarCBLocalAdicionarPeca(Object selectedItem) {
        modalLocaisCBLocalAdicionarPeca.removeAllElements();
        modalLocaisCBLocalAdicionarPeca.addAll(DadosDaAplicacao.INSTANCE.getLocais());
        modalLocaisCBLocalAdicionarPeca.removeElement(selectedItem);
    }

    private void fechar() {
        dispose();
    }
}
