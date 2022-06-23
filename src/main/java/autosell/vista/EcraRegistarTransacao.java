package autosell.vista;

import autosell.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcraRegistarTransacao extends JDialog {
    private JPanel panel1;
    private JButton btnRegistar;
    private JButton btnCancelar;
    private JComboBox comboCliente;
    private JComboBox comboLocal;
    private JButton btnCriarCliente;
    private JComboBox comboVeiculo;

    private DefaultComboBoxModel<Cliente> modalClientes;
    private DefaultComboBoxModel<Local> modalLocais;
    private DefaultComboBoxModel<Veiculo> modalVeiculos;
    private Transacao transacao;

    public EcraRegistarTransacao(Frame parent, boolean modal ) {
        super(parent, "Ecra registar",modal);
        setContentPane(panel1);
        pack();

        initComponentes();
        atualizarClientes();
        atualizarLocais();
    }


    public static Transacao mostrarCriacaoTransacao(Frame parent){
        EcraRegistarTransacao ecraRegistarTransacao = new EcraRegistarTransacao(parent, true);
        ecraRegistarTransacao.setLocationRelativeTo(parent);
        ecraRegistarTransacao.setVisible(true);

        return ecraRegistarTransacao.transacao;
    }

    public void initComponentes(){
        modalClientes = new DefaultComboBoxModel<>();
        modalLocais = new DefaultComboBoxModel<>();
        modalVeiculos = new DefaultComboBoxModel<>();
        comboCliente.setModel(modalClientes);
        comboLocal.setModel(modalLocais);
        comboVeiculo.setModel(modalVeiculos);

        comboLocal.addActionListener(this::comoboLocalActionPerformed);
        btnRegistar.addActionListener(this::btnRegistarActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    public void atualizarClientes(){
        modalClientes.removeAllElements();
        for (Cliente cliente : DadosDaAplicacao.INSTANCE.getClientes()) {
            modalClientes.addElement(cliente);
        }
    }

    public void atualizarLocais(){
        modalLocais.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            modalLocais.addElement(local);
        }
    }

    public void atualizarVeiculos(Local local){
        modalVeiculos.removeAllElements();
        for (Veiculo veiculo : local.getVeiculos()) {
            modalVeiculos.addElement(veiculo);
        }
    }

    public void comoboLocalActionPerformed(ActionEvent evt){
        Local local = (Local) comboLocal.getSelectedItem();

        if (local != null){
            atualizarVeiculos(local);
        }
    }

    public void btnRegistarActionPerformed(ActionEvent evt){
        Cliente cliente = (Cliente) comboCliente.getSelectedItem();
        if (cliente == null){
            return;
        }
        Local local = (Local) comboLocal.getSelectedItem();
        if (local == null){
            return;
        }
        Veiculo veiculo = (Veiculo) comboVeiculo.getSelectedItem();
        if (veiculo == null){
            return;
        }

        transacao = new Transacao(new Data(), cliente, veiculo, local);
        fechar();
    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar(){
        dispose();
    }
}
