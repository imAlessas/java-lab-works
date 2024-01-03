import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentContainer extends SortedContainer{

    //Costruisce un contenitore vuoto
    public StudentContainer(){
      super();
    }

    /* Costruisce un contenitore e vi inserisce oggetti di tipo Student
      usando i dati letti dal file filename, nel formato nome:matricola */
    public StudentContainer(String filename) throws IOException{
        super();
        try {
            FileReader source = new FileReader(filename);
            Scanner file = new Scanner(source);
    
            while(file.hasNextLine()){
                Scanner word = new Scanner(file.nextLine());
                word.useDelimiter(":");
    
                String nome = word.next();
                int matricola = Integer.parseInt(word.next());
    
                super.add(new Student(nome, matricola));
            }
    
            file.close();
            source.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /*
        Inserisce il nuovo oggetto compObj di tipo Student nel contenitore. 
        Questo metodo sovrascrive il metodo omonimo di SortedContainer. Se  
        l'oggetto compObj non e` di tipo Student il metodo deve lanciare
        IllegalArgumentException. Per il resto il comportamento del metodo e` 
        identico a quello del metodo omonimo di SortedContainer
    */
    public void add(Comparable compObj){
        if(compObj instanceof Student){ 
            super.add(compObj);
        } else 
            throw new IllegalArgumentException();
    }

    /*
        Crea un nuovo oggetto Student con il nome n e la matricola m, e 
        successivamente lo inserisce nel contenitore con le stesse modalita`
        del metodo add(Comparable compObj)
    */
    public void add(String n, int m){
        add(new Student(n, m));
    }
}
