package autosell.vista;

import autosell.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraCriarCliente extends JDialog {
    private JPanel panel1;
    private JButton btnCriarCliente;
    private JButton btnCancelar;
    private JTextField txtNIF;
    private JTextField txtNome;
    private Cliente cliente;

    public EcraCriarCliente(Dialog owner, boolean modal ) {
        super( owner, "Ecra Criar Cliente", modal);
        setContentPane(panel1);
        pack();

        initComponentes();
    }

    public static Cliente mostrarCriacaoCliente(Dialog owner){
        EcraCriarCliente ecraCriarCliente = new EcraCriarCliente(owner, true);
        ecraCriarCliente.setLocationRelativeTo(owner);
        ecraCriarCliente.setVisible(true);

        return ecraCriarCliente.getCliente();
    }

    private Cliente getCliente() {
        return cliente;
    }

    public void initComponentes(){
        btnCriarCliente.addActionListener(this::btnCriarClienteActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private boolean isNomeValido(String nome){
        if (nome == null || nome.trim().length() < 4){
            return false;
        }

        return true;
    }

    private boolean isNIFValido(String NIF){
        if (NIF == null || NIF.trim().length() != 8){
            return false;
        }

        return true;
    }



    public void btnCriarClienteActionPerformed(ActionEvent evt) {
        if (!isNomeValido(txtNome.getText())){
            return;
        }

        if (!isNIFValido(txtNIF.getText())){
            return;
        }

        cliente = new Cliente(txtNome.getText(), txtNIF.getText());
        fechar();

    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar(){
        dispose();
    }
}
