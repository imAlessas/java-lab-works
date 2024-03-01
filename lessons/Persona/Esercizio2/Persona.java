package Esercizio2;

public class Persona {
    private final String nome;
    private final String cognome;
    private final String cFiscale;
    private String citta;

    public Persona(){
        nome = cognome = cFiscale = citta = null;
    }

    public Persona(String nome, String cognome, String cFiscale, String citta){
        this.nome = nome;
        this.cognome = cognome;
        this.cFiscale =cFiscale ;
        this.citta = citta;
    }

    public String getNome(){ return nome; }

    public String getCognome(){ return cognome; }

    public String getFiscale(){ return cFiscale; }

    public String getCitta(){ return citta; }

    public int annoNascita(){
        return Integer.parseInt(cFiscale.charAt(6) + "" + cFiscale.charAt(7));
    }

    public String toString(){
        return nome + " " + cognome;
    }

    public static void main(String[] args) {
        Persona io = new Persona("Alessandro", "Trigolo", "TRGLSN02R30F241H", "Stra");
        System.out.println(io + " - " + io.annoNascita());
    }
}
