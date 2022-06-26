package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.DadosDaAplicacao;
import autosell.modelo.Local;
import autosell.modelo.Veiculo;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

        buttonFiltrarVeiculosLocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listTodosLocais.getSelectedValue()==null){
                    JOptionPane.showMessageDialog(null,"Deve Selecionar um local para consultar");
                }else
                    atualizarListaVeiculosFiltradaPorLocal();
                System.out.println(listTodosLocais.getSelectedValue());

            }
        });
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
    }

    public void atualizarTodosLocais() {
        modeloTodosLocais.removeAllElements();
        for (Local local : DadosDaAplicacao.INSTANCE.getLocais()) {
            modeloTodosLocais.addElement(local);
        }
    }

    public void atualizarListaVeiculosFiltradaPorLocal() {
        modeloVeiculosFiltrados.removeAllElements();
        for (Veiculo veiculo : DadosDaAplicacao.INSTANCE.getVeiculos()) {
            modeloVeiculosFiltrados.addElement(veiculo);
        }

    }
}
