package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcraVerTodosClientes extends JFrame {

    private JList lstTodosClientes;
    private JPanel panel1;
    private DefaultListModel modeloTodosClientes;

    public EcraVerTodosClientes() {
        setTitle("Todos os Clientes Registados");
        setContentPane(panel1);
        pack();

        initComponentes();
        DadosDaAplicacao.INSTANCE.addCliente(new Cliente("dwqdwdwq", 12312321));
        DadosDaAplicacao.INSTANCE.addCliente(new Cliente("dwqdwdwq", 12312321));
        atualizarTodosClientes();

        lstTodosClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
               lstMouseClickActionPerformed(evt);
            }
        });
    }

    public static void mostrarTodosClientes(Frame parent){
        EcraVerTodosClientes ecraVerTodosClientes = new EcraVerTodosClientes();
        ecraVerTodosClientes.setLocationRelativeTo(parent);
        ecraVerTodosClientes.setVisible(true);
    }

    public void initComponentes(){
        modeloTodosClientes = new DefaultListModel();
        lstTodosClientes.setModel(modeloTodosClientes);

    }

    public void atualizarTodosClientes(){
        modeloTodosClientes.removeAllElements();
        for (Cliente cliente : DadosDaAplicacao.INSTANCE.getClientes()) {
            modeloTodosClientes.addElement(cliente);

        }
    }

    public void lstMouseClickActionPerformed(MouseEvent evt){
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            Cliente cliente = (Cliente) list.getSelectedValue();
            EcraVerDetalhesCliente.mostrarDetalhesCliente(this, cliente);

        }
    }

}
