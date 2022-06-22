package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;

import javax.swing.*;
import java.awt.*;

public class EcraVerTodosClientes extends JFrame {

    private JList lstTodosClientes;
    private JPanel panel1;
    private DefaultListModel modeloTodosClientes;

    public EcraVerTodosClientes(Frame parent) {
        setTitle("Todos os Clientes Registados");
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);

        initComponentes();
        DadosDaAplicacao.INSTANCE.addCliente(new Cliente("dwqdwdwq", 12312321));
        atualizarTodosClientes();

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

}
