package autosell.modelo;

public class Cliente {
    private String nome;
    private double NIF;

    public Cliente(String nome, double NIF) {
        this.nome = nome;
        this.NIF = NIF;
    }

    public String getNome() {
        return nome;
    }

    public double getNIF() {
        return NIF;
    }

    @Override
    public String toString() {

        return nome + " - " + NIF;
    }
}
