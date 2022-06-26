package autosell.modelo;

import java.util.LinkedList;

public class Local {
    private String nome;
    private LinkedList<Peca> pecas;
    private LinkedList<Veiculo> veiculos;

    protected Local(String nome) {
        this.nome = nome;
        veiculos = new LinkedList<>();
        pecas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public boolean pecaEmStock(String nome){
        for (Peca peca : pecas) {
            if (peca.getNome().equals(nome))
                return true;
        }
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

    @Override
    public String toString() {
        return nome;
    }

    public void removePeca(Peca peca) {
        if (peca != null) {
            pecas.remove(peca);
        }
    }

    public void removeVeiculo(Veiculo veiculo) {
        if (veiculo != null) {
            veiculos.remove(veiculo);
        }
    }
}
