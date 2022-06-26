package autosell.modelo;

public class Cliente {
    private String nome;
    private String NIF;

    public Cliente(String nome, String NIF) {
        if (nome == null || nome.trim().length() < 4){
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
        if (NIF == null || NIF.trim().length() != 8){
            throw new IllegalArgumentException("NIF inválido");
        }
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
