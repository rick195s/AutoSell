package autosell.vista;

import autosell.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcraAdicionarEvento extends JDialog {
    private JComboBox comboLocal;
    private JPanel panelEvento;
    private JButton btnCriarLocalDeEvento;
    private JList listTodosVeiculos;
    private JList listVeiculosAdicionados;
    private JButton buttonCriarEvento;
    private JButton buttonCancelar;
    private JTextField textFieldNomeEvento;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFim;
    private Evento evento;


    private DefaultListModel<Veiculo> modelVeiculos;
    private DefaultListModel<Veiculo> modelVeiculosAdicionados;
    private DefaultComboBoxModel<Local> modelLocais;

    public EcraAdicionarEvento() {
        setTitle("Adicionar Evento");
        setContentPane(panelEvento);
        pack();

        initComponentes();
        atualizarTodosLocais();
        atualizarTodosVeiculos();


        listTodosVeiculos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                lstMouseClickActionPerformed(evt);
            }
        });
        listVeiculosAdicionados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                listVeiculosAdicionadosActionPerformed(evt);
            }
        });
    }

    private void atualizarTodosVeiculos() {
        modelVeiculos.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            for (Veiculo veiculo : local.getVeiculos()) {
                modelVeiculos.addElement(veiculo);
            }
        }
    }

    public void atualizarTodosLocais() {
        modelLocais.removeAllElements();
        modelLocais.addAll(DadosDaAplicacao.INSTANCE.getLocais());
    }


    public void atualizarLocais(){
        modelLocais.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            modelLocais.addElement(local);
        }
    }

    public static void mostrarCriacaoEvento(Frame parent){
        EcraAdicionarEvento ecraAdicionarEvento = new EcraAdicionarEvento();
        ecraAdicionarEvento.setLocationRelativeTo(parent);
        ecraAdicionarEvento.setVisible(true);

    }


    public void initComponentes() {
        modelLocais = new DefaultComboBoxModel<>();
        modelVeiculos = new DefaultListModel<>();
        modelVeiculosAdicionados = new DefaultListModel<>();

        listVeiculosAdicionados.setModel(modelVeiculosAdicionados);
        comboLocal.setModel(modelLocais);

        listTodosVeiculos.setModel(modelVeiculos);

        buttonCriarEvento.addActionListener(this::btnCriarEvento);
        buttonCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnCriarLocalDeEvento.addActionListener(this::btnCriarNovoLocal);



    }

    private void btnCriarNovoLocal(ActionEvent actionEvent) {
        Local local = EcraCriarLocal.mostrarCriacaoLocal(this);
        if (local != null){
            DadosDaAplicacao.INSTANCE.addLocal(local);
            atualizarLocais();
        }

    }

    private void btnCriarEvento(ActionEvent actionEvent) {

        try {
            evento = new Evento((Local) comboLocal.getSelectedItem(),textFieldNomeEvento.getText(),Data.parseData(textFieldDataInicio.getText()),Data.parseData(textFieldDataFim.getText()));
            DadosDaAplicacao.INSTANCE.addEvento(evento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        dispose();

    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        dispose();
    }


    public void lstMouseClickActionPerformed(MouseEvent evt){
        int botao = evt.getButton();
        if (botao == MouseEvent.BUTTON1){
            int clickCount = evt.getClickCount();
            if( clickCount == 2) {
                Veiculo veiculo = (Veiculo) listTodosVeiculos.getSelectedValue();
                modelVeiculosAdicionados.addElement(veiculo);
                modelVeiculos.removeElement(veiculo);
            }
        }
    }

    public void listVeiculosAdicionadosActionPerformed(MouseEvent evt){
        int botao = evt.getButton();
        if (botao == MouseEvent.BUTTON1){
            int clickCount = evt.getClickCount();
            if( clickCount == 2) {
                Veiculo veiculo = (Veiculo) listVeiculosAdicionados.getSelectedValue();
                modelVeiculos.addElement(veiculo);
                modelVeiculosAdicionados.removeElement(veiculo);

            }
        }
    }
}
