import javax.swing.*;
import java.awt.event.ActionEvent;

public class EcraRegistarTransacao extends JFrame {
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panel1;

    public EcraRegistarTransacao() {
        super("Ecra registar");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        comboBox1.addActionListener(this::changeLabels);
    }

    public void changeLabels(ActionEvent e){
        System.out.println(comboBox1.getSelectedItem());
    }

    public static void main(String[] args) {
        new EcraRegistarTransacao().setVisible(true);

    }
}
