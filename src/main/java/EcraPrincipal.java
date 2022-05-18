import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class EcraPrincipal extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton btnAdicionar;
    private JButton btnRegistar;
    private JButton btnEstatisticas;
    private JButton btnConsultar;
    private JLabel dateLabel;

    public EcraPrincipal() {
        super("Ecra Principal");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        new Timer(500, this::updateDate).start();
        btnRegistar.addActionListener(this::btnRegistarActionPerformed);

    }

    private void updateDate(ActionEvent actionEvent) {
        Date date = new Date();
        dateLabel.setText(date.toString());
    }


    public static void main(String[] args) {

        new EcraPrincipal().setVisible(true);
    }

    public void btnRegistarActionPerformed(ActionEvent actionEvent) {

    }

}
