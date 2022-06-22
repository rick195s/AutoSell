package autosell.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EcraPrincipal extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton btnRegistarTransacao;
    private JButton btnEstatisticas;
    private JLabel dateLabel;
    private JButton btnAdicionarEvento;
    private JButton btnAdicionarPeca;
    private JButton btnAdicionarVeiculo;
    private JButton btnVerLocaisRegistados;
    private JButton btnVerPecasRegistadas;
    private JButton btnVerTodosClientes;

    public EcraPrincipal() {
        super("Ecra Principal");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        new Timer(500, this::updateDate).start();
        btnRegistarTransacao.addActionListener(this::btnRegistarTransacaoActionPerformed);
        btnVerTodosClientes.addActionListener(this::btnVerTodosClientesActionPerformed);
    }

    private void updateDate(ActionEvent actionEvent) {
        Date date = new Date();
        dateLabel.setText(date.toString());
    }


    public static void main(String[] args) {

        new EcraPrincipal().setVisible(true);
    }

    public void btnRegistarTransacaoActionPerformed(ActionEvent actionEvent) {
        EcraRegistarTransacao ecraRegistarTransacao = new EcraRegistarTransacao();
        ecraRegistarTransacao.setVisible(true);
    }

    public void btnVerTodosClientesActionPerformed(ActionEvent actionEvent) {
        EcraVerTodosClientes ecraVerTodosClientes = new EcraVerTodosClientes();
        ecraVerTodosClientes.setLocationRelativeTo(this);
        ecraVerTodosClientes.setVisible(true);
    }

}
