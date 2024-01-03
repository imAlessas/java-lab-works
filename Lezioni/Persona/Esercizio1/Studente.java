package Esercizio1;

public class Studente extends Persona{
    private final int matricola;
    private int esami; // numero esami sostenuti

    public Studente(String nome, String cognome, int matricola){
        super(nome, cognome);
        this.matricola = matricola;
        esami = 0;
    }

    public int getMatricola(){
        return matricola;
    }

    public int getEsami(){
        return esami;
    }

    public void setEsami(int value){
        esami = value;
    }

}
