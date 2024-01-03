package Esercizio1;

public class Persona {
    private final String nome;
    private final String cognome;

    public Persona(String name, String surname){
        this.nome = name;
        this.cognome = surname;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String toString(){
        return nome + " " + cognome;
    }

}