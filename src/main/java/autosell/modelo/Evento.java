package autosell.modelo;

import java.util.Date;
import java.util.LinkedList;

public class Evento {

    private Local local;
    private String nome;
    private Data dataInicio;
    private Data dataFim;

    public Evento(Local local, String nome, Data dataInicio, Data dataFim) {
        this.local = local;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;


        if (dataInicio.compareTo(dataFim)!=1) {
            throw new IllegalArgumentException("Datas invalidas");
        }
    }


    public Local getLocal() {
        return local;
    }
}
