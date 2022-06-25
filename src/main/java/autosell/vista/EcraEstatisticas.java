package autosell.vista;

import autosell.modelo.Cliente;

import javax.swing.*;
import java.awt.*;

public class EcraEstatisticas extends JDialog{
    private JLabel labelFilialMaisVende;
    private JLabel labelFilialMaisProfit;
    private JLabel labelNumCarrosVendidos;
    private JLabel labelNumCarrosStock;
    private JLabel labelNumPneusStock;
    private JLabel labelProfitSede;
    private JPanel panel1;

    public EcraEstatisticas(Frame parent, boolean modal) {
        super(parent, "Ecra Criar Cliente", modal);
        setContentPane(panel1);
        pack();
    }


    public static void mostrarEstatisticas(Frame parent){
        EcraEstatisticas ecraEstatisticas = new EcraEstatisticas(parent, true);
        ecraEstatisticas.setLocationRelativeTo(parent);
        ecraEstatisticas.setVisible(true);
    }
}
