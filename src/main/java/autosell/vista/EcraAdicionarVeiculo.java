package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Peca;
import autosell.modelo.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EcraAdicionarVeiculo extends JFrame {
    private JButton btnAdicionarVeiculo;
    private JButton btnCancelar;
    private JPanel panelAdicionarVeiculo;
    private JTextField txtNome;
    private JTextField txtMatricula;
    private JTextField txtMarca;
    private JTextField txtValor;
    private JComboBox<Local> cbLocalAdicionarVeiculo;

    private DefaultComboBoxModel<Local> modalLocais;

    public EcraAdicionarVeiculo() {
        setTitle("Adicionar Veiculo");
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
        // TODO
        modalLocais = new DefaultComboBoxModel<>();

        cbLocalAdicionarVeiculo.setModel(modalLocais);

        btnAdicionarVeiculo.addActionListener(this::btnAdicionarVeiculoActionPerformed);
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    public void btnAdicionarVeiculoActionPerformed(ActionEvent evt) {
        if (!isNomeValido(txtNome.getText())) {
            return;
        }
        if (!isMatriculaValida(txtMatricula.getText())) {
            return;
        }
        if (!isMarcaValida(txtMarca.getText())) {
            return;
        }
        if (!isValorValido(Double.parseDouble(txtValor.getText()))) {
            return;
        }
        if (cbLocalAdicionarVeiculo != null) {
            System.out.println("entrei");
            DadosDaAplicacao.INSTANCE.addVeiculoA(((Local) cbLocalAdicionarVeiculo.getSelectedItem()),
                    new Veiculo(txtNome.getText(),
                            txtMatricula.getText().toUpperCase(),
                            txtMarca.getText(),
                            Double.parseDouble(txtValor.getText())));
            JOptionPane.showMessageDialog(null, "Veiculo adicionado com sucesso!");
            fechar();
        }

    }

    private boolean isNomeValido(String nome) {
        if (nome == null || nome.trim().length() < 2) {
            return false;
        }
        return true;
    }

    private boolean isMatriculaValida(String matricula) {
        if (matricula.trim().length() != 8) {
            return false;
        }
        Matcher matcher = Pattern.compile("\\A(\\d{2}\\-\\d{2}\\-[A-Z]{2}|\\d{2}\\-[A-Z]{2}\\-\\d{2}|[A-Z]{2}\\-\\d{2" +
                "}\\-\\d{2})\\z").matcher(matricula.toUpperCase());
        if (!matcher.find()) {
            return false;
        }
        return true;
    }

    private boolean isMarcaValida(String marca) {
        if (marca == null) {
            return false;
        }
        return true;
    }

    private boolean isValorValido(Double valor) {
        if (valor == null || valor <= 0) {
            return false;
        }
        return true;
    }

    public void atualizarTodosLocais() {
        modalLocais.removeAllElements();
        modalLocais.addAll(DadosDaAplicacao.INSTANCE.getLocais());
    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        fechar();
    }

    private void fechar() {
        dispose();
    }
}
