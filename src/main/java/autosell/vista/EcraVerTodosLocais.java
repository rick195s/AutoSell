package autosell.vista;

import autosell.modelo.*;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class EcraVerTodosLocais extends JFrame{
    private JList<Local> listTodosLocais;
    private JPanel panelLocais;

    private JList<Veiculo> listVeiculosFiltradosPorLocal;
    private JButton buttonFiltrarVeiculosLocal;

    private DefaultListModel<Local> modeloTodosLocais;
    private DefaultListModel<Veiculo> modeloVeiculosFiltrados;

    public EcraVerTodosLocais() {
        setTitle("Todos os Locais Registados");
        setContentPane(panelLocais);
        pack();

        initComponentes();
        atualizarTodosLocais();
    }

    public static void mostrarTodosLocais(Frame parent) {
        EcraVerTodosLocais ecraVerTodosLocais = new EcraVerTodosLocais();
        ecraVerTodosLocais.setLocationRelativeTo(parent);
        ecraVerTodosLocais.setVisible(true);
    }

    public void initComponentes() {
        modeloTodosLocais = new DefaultListModel<>();
        modeloVeiculosFiltrados = new DefaultListModel<>();
        listTodosLocais.setModel(modeloTodosLocais);
        listVeiculosFiltradosPorLocal.setModel(modeloVeiculosFiltrados);
        buttonFiltrarVeiculosLocal.addActionListener(this::btnFiltrarPorLocal);
    }

    private void btnFiltrarPorLocal(ActionEvent evt) {
        if (listTodosLocais.getSelectedValue()==null){
            JOptionPane.showMessageDialog(null,"Deve Selecionar um local para consultar");
        }else
            atualizarListaVeiculosFiltradaPorLocal();
    }

    public void atualizarTodosLocais() {
        modeloTodosLocais.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            modeloTodosLocais.addElement(local);
        }
    }

    public void atualizarListaVeiculosFiltradaPorLocal() {
        modeloVeiculosFiltrados.removeAllElements();

        Local localSelecionado = (Local) listTodosLocais.getSelectedValue();
        for (Veiculo veiculo : localSelecionado.getVeiculos()) {
            modeloVeiculosFiltrados.addElement(veiculo);
        }
    }


}
