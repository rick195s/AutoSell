package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;

import javax.swing.*;
import java.awt.*;

public class EcraVerTodosClientes extends JFrame {

    private JList lstTodosClientes;
    private JPanel panel1;
    private DefaultListModel modeloTodosClientes;

    public EcraVerTodosClientes() {
        setTitle("Todos os Clientes Registados");
        setContentPane(panel1);
        pack();

        modeloTodosClientes = new DefaultListModel();
        lstTodosClientes.setModel(modeloTodosClientes);

        atualizarTodosClientes();

    }


    public void atualizarTodosClientes(){
        modeloTodosClientes.removeAllElements();
        for (Cliente cliente : DadosDaAplicacao.INSTANCE.getClientes()) {
            modeloTodosClientes.addElement(cliente);

        }
    }


}
