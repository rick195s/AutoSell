package autosell.modelo;

public class Cliente {
    private String nome;
    private String NIF;

    public Cliente(String nome, String NIF) {
        this.nome = nome;
        this.NIF = NIF;
    }

    public String getNome() {
        return nome;
    }

    public String getNIF() {
        return NIF;
    }

    @Override
    public String toString() {

        return nome + " - " + NIF;
    }

    public int compareTo(Cliente cliente){
        return NIF.compareTo(cliente.getNIF());
    }
}
