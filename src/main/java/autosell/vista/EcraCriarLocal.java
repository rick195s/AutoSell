package autosell.vista;

import autosell.modelo.Cliente;
import autosell.modelo.Local;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EcraCriarLocal extends JDialog {
    private JPanel panelCriarLocal;
    private JButton buttonCancelar;
    private JButton buttonCriarLocal;
    private JTextField textFieldLocal;
    private Local local;

    public EcraCriarLocal(Dialog owner, boolean modal ) {
        super( owner, "Ecra Criar Local", modal);
        setContentPane(panelCriarLocal);
        pack();

        initComponentes();
    }

    public static Local mostrarCriacaoLocal(Dialog owner){
        EcraCriarLocal ecraCriarLocal = new EcraCriarLocal(owner, true);
        ecraCriarLocal.setLocationRelativeTo(owner);
        ecraCriarLocal.setVisible(true);

        return ecraCriarLocal.getLocal();
    }

    private Local getLocal() {
        return local;
    }

    public void initComponentes(){
        buttonCriarLocal.addActionListener(this::btnCriarLocalActionPerformed);
        buttonCancelar.addActionListener(this::btnCancelarActionPerformed);
    }

    private boolean isNomeValido(String nome){
        if (nome == null || nome.trim().length() < 4){
            return false;
        }

        return true;
    }



    public void btnCriarLocalActionPerformed(ActionEvent evt) {
        if (!isNomeValido(textFieldLocal.getText())){
            return;
        }

        local = new Local(textFieldLocal.getText());
        dispose();

    }

    public void btnCancelarActionPerformed(ActionEvent evt) {
        dispose();
    }

}
