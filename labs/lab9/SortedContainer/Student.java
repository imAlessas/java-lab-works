public class Student implements Comparable{
    private final String nome;
    private final int matricola;

    public Student(String nome, int matricola){   
        this.nome = nome;
        this.matricola = matricola;
    }

    //restituisce il numero di matricola
    public int getMatricola(){ 
        return matricola; 
    }

    //restituisce il nome
    public String getNome(){ 
        return nome; 
    }

    //estituisce la stringa "matricola:nome"
    public String toString(){ 
        return matricola + ":" + nome; 
    }

    /* confronta in base al numero di matricola (in particolare due oggetti di 
        tipo Student sono "uguali" quando hanno la stessa matricola)
        Lancia ClassCastException se s non si riferisce ad un oggetto Student  */
    public int compareTo(Object s){  
        return matricola - ((Student) s).matricola;
    }

}