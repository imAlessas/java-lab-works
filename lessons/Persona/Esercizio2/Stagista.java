package Esercizio2;

public class Stagista extends Persona{
    private final int id;
    private int ore;

    public Stagista(String nome, String cognome, String cFiscale, String citta, int id, int ore){
        super(nome, cognome, cFiscale, citta);
        this.id = id;
        this.ore = ore;
    }

    public int getId(){ return id; }

    public int getOre(){ return ore; }

    public void setOre(int value){ ore = value; }
}
