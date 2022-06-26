package autosell.vista;

import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Transacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class EcraPrincipal extends JFrame{
    private JPanel panel1;
    private JList<Transacao> lstUltimasTransacoes;
    private DefaultListModel<Transacao> modeloUltimasTransacoes;
    private JButton btnRegistarTransacao;
    private JButton btnEstatisticas;
    private JLabel dateLabel;
    private JButton btnAdicionarEvento;
    private JButton btnAdicionarPeca;

    private JButton btnAdicionarVeiculo;
    private JButton btnVerLocaisRegistados;
    private JButton btnVerPecasRegistadas;
    private JButton btnVerTodosClientes;

    public EcraPrincipal() {
        super("Ecra Principal");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        initComponentes();
        atualizarUltimasTransacoes();
    }

    private void initComponentes(){
        new Timer(500, this::updateDate).start();
        btnRegistarTransacao.addActionListener(this::btnRegistarTransacaoActionPerformed);
        btnVerTodosClientes.addActionListener(this::btnVerTodosClientesActionPerformed);
        btnVerLocaisRegistados.addActionListener(this::btnVerTodosLocaisActionPerformed);
        btnEstatisticas.addActionListener(this::btnEstatisticasActionPerformed);
        btnAdicionarPeca.addActionListener(this::btnAdicionarPecaActionPerformed);

        btnAdicionarVeiculo.addActionListener(this::btnAdicionarVeiculoActionPerformed);

        btnVerPecasRegistadas.addActionListener(this::btnVerPecasRegistadasActionPerformed);


        modeloUltimasTransacoes = new DefaultListModel<>();
        lstUltimasTransacoes.setModel(modeloUltimasTransacoes);
    }

    private void atualizarUltimasTransacoes(){
        modeloUltimasTransacoes.removeAllElements();
        for (Transacao transacao : DadosDaAplicacao.INSTANCE.getTransacoes(15)) {
            modeloUltimasTransacoes.addElement(transacao);
        }

    }

    private void updateDate(ActionEvent actionEvent) {
        Date date = new Date();
        dateLabel.setText(date.toString());
    }

    public static void main(String[] args) {

        new EcraPrincipal().setVisible(true);
    }

    public void btnRegistarTransacaoActionPerformed(ActionEvent evt) {
        Transacao transacao = EcraRegistarTransacao.mostrarCriacaoTransacao(this);
        if (transacao != null){
            DadosDaAplicacao.INSTANCE.addTransacao(transacao);
            atualizarUltimasTransacoes();
        }
    }

    public void btnVerTodosClientesActionPerformed(ActionEvent evt) {
        EcraVerTodosClientes.mostrarTodosClientes(this);
    }

    public void btnVerTodosLocaisActionPerformed(ActionEvent evt) {
        EcraVerTodosLocais.mostrarTodosLocais(this);
    }

    public void btnEstatisticasActionPerformed(ActionEvent evt) {
        EcraEstatisticas.mostrarEstatisticas(this);
    }

    public void btnAdicionarPecaActionPerformed(ActionEvent evt) {
        EcraAdicionarPeca.mostrarAdicionarPeca(this);
    }

    public void btnAdicionarVeiculoActionPerformed(ActionEvent evt) {
        EcraAdicionarVeiculo.mostrarAdicionarVeiculo(this);
    }

    public void btnVerPecasRegistadasActionPerformed(ActionEvent evt) {
        EcraVerTodasPecas.mostrarTodasPecas(this);
    }
}
