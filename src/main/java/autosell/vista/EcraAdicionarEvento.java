package autosell.vista;

import autosell.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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


    private DefaultListModel<Veiculo> modalVeiculos;
    private DefaultComboBoxModel<Local> modalLocais;

    public EcraAdicionarEvento() {
        setTitle("Adicionar Evento");
        setContentPane(panelEvento);
        pack();

        initComponentes();
        atualizarTodosLocais();
    }

    public static void mostrarCriacaoEvento(Frame parent){
        EcraAdicionarEvento ecraAdicionarEvento = new EcraAdicionarEvento();
        ecraAdicionarEvento.setLocationRelativeTo(parent);
        ecraAdicionarEvento.setVisible(true);

    }


    public void initComponentes() {
        modalLocais = new DefaultComboBoxModel<>();
        modalVeiculos = new DefaultListModel<>();
        comboLocal.setModel(modalLocais);

        listTodosVeiculos.setModel(modalVeiculos);

        buttonCriarEvento.addActionListener(this::btnCriarEvento);
        buttonCancelar.addActionListener(this::btnCancelarActionPerformed);
        btnCriarLocalDeEvento.addActionListener(this::btnCriarNovoLocal);
        comboLocal.addActionListener(this::updateListVeiculosDisponiveis);
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        System.out.println(evento);
//       dispose();
    }

    private void updateListVeiculosDisponiveis(ActionEvent actionEvent) {
        atualizarListaVeiculosDisponiveisPorLocal();
    }


    public void atualizarTodosLocais() {
        modalLocais.removeAllElements();
        modalLocais.addAll(DadosDaAplicacao.INSTANCE.getLocais());
    }


    public void atualizarLocais(){
        modalLocais.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            modalLocais.addElement(local);
        }
    }

    public void atualizarVeiculos(Local local){
        modalVeiculos.removeAllElements();
        for (Veiculo veiculo : local.getVeiculos()) {
            modalVeiculos.addElement(veiculo);
        }
    }
    public void comoboLocalActionPerformed(ActionEvent evt){
        Local local = (Local) comboLocal.getSelectedItem();

        if (local != null){
            atualizarVeiculos(local);
        }
    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        dispose();
    }

    public void atualizarListaVeiculosDisponiveisPorLocal() {
        modalVeiculos.removeAllElements();

        Local localSelecionado = (Local) comboLocal.getSelectedItem();
        if(localSelecionado!=null) {
            for (Veiculo veiculo : localSelecionado.getVeiculos()) {
                modalVeiculos.addElement(veiculo);
            }
        }

    }

}
