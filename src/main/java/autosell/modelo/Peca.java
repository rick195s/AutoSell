package autosell.modelo;

public class Peca {
    private String nome;

    protected Peca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
