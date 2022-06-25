package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.Estatisticas;

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

        getEstatisticas();
    }

    private void getEstatisticas() {
        labelFilialMaisVende.setText(Estatisticas.getFilialMaisVende().getNome());
        labelFilialMaisProfit.setText(Estatisticas.getFilialMaisProfit().getNome());
        labelProfitSede.setText(Estatisticas.profitSede()+" €");
        labelNumCarrosVendidos.setText(Estatisticas.getNumCarrosVendidos()+"");

    }

    public static void mostrarEstatisticas(Frame parent){
        EcraEstatisticas ecraEstatisticas = new EcraEstatisticas(parent, true);
        ecraEstatisticas.setLocationRelativeTo(parent);
        ecraEstatisticas.setVisible(true);
    }
}
