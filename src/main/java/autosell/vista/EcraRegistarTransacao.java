package autosell.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraRegistarTransacao extends JFrame {
    private JPanel panel1;
    private JButton btnRegistar;
    private JButton btnCancelar;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton btnCriarCliente;
    private JComboBox comboBox4;

    public EcraRegistarTransacao() {
        super("Ecra registar");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }


    public static void main(String[] args) {
        new EcraRegistarTransacao().setVisible(true);

    }
}
