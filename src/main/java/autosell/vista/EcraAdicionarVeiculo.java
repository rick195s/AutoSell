package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Peca;
import autosell.modelo.Veiculo;

import javax.swing.*;
import java.awt.*;

public class EcraAdicionarVeiculo extends JFrame{
    private JComboBox<Local> cbLocalARetirarVeiculo;
    private JButton buttonAdicionarVeiculo;
    private JButton buttonCancelar;
    private JPanel panelAdicionarVeiculo;
    private JTextField textField1;

    private DefaultComboBoxModel<Local> modalLocais;
    private DefaultComboBoxModel<Veiculo> modalVeiculos;
    private DefaultComboBoxModel<Local> modalLocaisCBLocalAdicionarVeiculo;

    public EcraAdicionarVeiculo() {
        setTitle("Adicionar Peça");
        setContentPane(panelAdicionarVeiculo);
        pack();

        initComponentes();
        atualizarTodosLocais();
    }

    public static void mostrarAdicionarVeiculo(Frame parent) {
        EcraAdicionarVeiculo ecraAdicionarVeiculo = new EcraAdicionarVeiculo();
        ecraAdicionarVeiculo.setLocationRelativeTo(parent);
        ecraAdicionarVeiculo.setVisible(true);
    }

    public void initComponentes() {
        modalLocais = new DefaultComboBoxModel<>();
        modalVeiculos = new DefaultComboBoxModel<>();
        modalLocaisCBLocalAdicionarVeiculo = new DefaultComboBoxModel<>();

        cbLocalARetirarVeiculo.setModel(modalLocais);
    }

    public void atualizarTodosLocais() {
        modalLocais.removeAllElements();
        modalLocais.addAll(DadosDaAplicacao.INSTANCE.getLocais());
    }

    // TODO
}
