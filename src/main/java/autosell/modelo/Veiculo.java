package autosell.modelo;

public class Veiculo {

    private String nome;
    private String matricula;
    private String marca;
    private double valor;

    public Veiculo(String nome, String matricula, String marca, double valor) {
        this.nome = nome;
        this.matricula = matricula;
        this.marca = marca;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }
    @Override
    public String toString() {
        return nome+" - "+matricula+" - "+ marca + " - " + valor +" €";
    }
}
