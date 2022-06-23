package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Transacao;

import javax.swing.*;
import java.awt.*;

public class EcraVerDetalhesCliente extends JDialog{
    private JList lstTransacoesCliente;
    private JLabel txtNome;
    private JLabel txtNIF;
    private JPanel panel1;
    private JList lstTrasacoesCliente;
    private DefaultListModel<Transacao> modeloTransacoesCliente;

    public EcraVerDetalhesCliente(Frame parent, boolean modal, Cliente cliente) {
        super(parent,modal);
        setTitle("Detalhes do Cliente");
        setContentPane(panel1);
        pack();

        initComponentes();
        txtNome.setText(cliente.getNome());
        txtNIF.setText(Double.toString(cliente.getNIF()));
        atualizarTransacoes(cliente);

    }

    public void initComponentes(){
        modeloTransacoesCliente = new DefaultListModel();
        lstTransacoesCliente = new JList();
        lstTransacoesCliente.setModel(modeloTransacoesCliente);
    }

    public static void mostrarDetalhesCliente(Frame parent, Cliente cliente){
        EcraVerDetalhesCliente ecraVerDetalhesCliente = new EcraVerDetalhesCliente(parent, true, cliente);
        ecraVerDetalhesCliente.setLocationRelativeTo(parent);
        ecraVerDetalhesCliente.setVisible(true);

    }


    public void atualizarTransacoes(Cliente cliente){
        modeloTransacoesCliente.removeAllElements();
        for (Transacao transacao : DadosDaAplicacao.INSTANCE.getTransacoesDe(cliente)) {
            modeloTransacoesCliente.addElement(transacao);
        }
    }
}
