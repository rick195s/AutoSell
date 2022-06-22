package autosell.modelo;

import java.util.LinkedList;

public class Local {
    private String nome;
    private LinkedList<Peca> pecas;
    private LinkedList<Veiculo> veiculos;

    public Local(String nome) {
        this.nome = nome;
    }

    public boolean pecaEmStock(String nome){
        //TODO
        return false;
    }

    public LinkedList<Peca> getPecas() {
        return pecas;
    }

    public LinkedList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo){
        if (veiculo == null) {
            return;
        }

        veiculos.add(veiculo);
    }

    public void addPeca(Peca peca){
        if (peca == null){
            return;
        }

        pecas.add(peca);
    }

}