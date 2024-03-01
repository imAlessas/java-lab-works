package Esercizio2;

public class Impiegato extends Persona{
    private double stipendio;

    public Impiegato(String nome, String cognome, String cFiscale, String citta, double stipendio){
        super(nome, cognome, cFiscale, citta);
        this.stipendio = stipendio;
    }

    public double getStipendio(){ return stipendio; }

    public void setStipendio(double value){ stipendio = value; }
}
