package autosell.modelo;

public class Veiculo {

    private String nome;
    private String matricula;
    private String marca;

    public Veiculo(String nome, String matricula, String marca) {
        this.nome = nome;
        this.matricula = matricula;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }
}
