import javax.swing.*;

public class EcraRegistarCompraVenda extends JFrame {
    private JComboBox comboBox1;
    private JTextField textField2;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JPanel panel1;

    public EcraRegistarCompraVenda() {
        super("Ecra registar");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new EcraRegistarCompraVenda().setVisible(true);

    }
}
