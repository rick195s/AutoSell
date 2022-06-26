package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcraVerTodosClientes extends JFrame {

    private JList<Cliente> lstTodosClientes;
    private JPanel panel1;
    private DefaultListModel<Cliente> modeloTodosClientes;

    public EcraVerTodosClientes() {
        setTitle("Todos os Clientes Registados");
        setContentPane(panel1);
        pack();

        initComponentes();
        atualizarTodosClientes();
    }

    public static void mostrarTodosClientes(Frame parent){
        EcraVerTodosClientes ecraVerTodosClientes = new EcraVerTodosClientes();
        ecraVerTodosClientes.setLocationRelativeTo(parent);
        ecraVerTodosClientes.setVisible(true);
    }

    public void initComponentes(){
        modeloTodosClientes = new DefaultListModel<>();
        lstTodosClientes.setModel(modeloTodosClientes);
        lstTodosClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lstMouseClickActionPerformed(evt);
            }
        });
    }

    public void atualizarTodosClientes(){
        modeloTodosClientes.removeAllElements();
        for (Cliente cliente : DadosDaAplicacao.INSTANCE.getClientes()) {
            modeloTodosClientes.addElement(cliente);

        }
    }

    public void lstMouseClickActionPerformed(MouseEvent evt){
        int botao = evt.getButton();
        if (botao == MouseEvent.BUTTON1){
            int clickCount = evt.getClickCount();
            if( clickCount == 2) {
                Cliente cliente = lstTodosClientes.getSelectedValue();
                EcraVerDetalhesCliente.mostrarDetalhesCliente(this, cliente);
            }
        }
    }

}
