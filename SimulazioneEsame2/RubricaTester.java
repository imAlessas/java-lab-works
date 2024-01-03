import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

// nome e cognome del candidato, matricola, data, numero della postazione


public class RubricaTester{   
    public static void main(String[] args){
        if(args.length != 2){
            System.err.println("Invalid parameters.");
            System.exit(1);
        }

        Rubrica r1 = new Rubrica();
        Rubrica r2 = new Rubrica();

        try {
            FileReader source = new FileReader(args[0]);
            Scanner file = new Scanner(source);

            while(file.hasNextLine()){
                String line = file.nextLine();
                Scanner word = new Scanner(line);

                String key = word.next();
                word.next(); // salto i ':'
                long value = Long.parseLong(word.next());

                r1.insert(key, value);

                word.close();
            }

            file.close();
            source.close();
        } catch (FileNotFoundException e) {
            System.err.println("Could not find the " + args[0] +" file.");
            System.exit(1);
        } catch(IOException e){
            System.err.println("Can't acces the source when the stream is closed.");
            System.exit(1);
        } catch(NoSuchElementException e){
            System.err.println("Formato inserimento sbagliato.");
        } catch(NumberFormatException e){
            System.err.println("Formato numero teelfonico scorretto.");
        }

        Scanner keyboard = new Scanner(System.in);
        while(keyboard.hasNext()){
            boolean done = false;
            while(!done){
                String name = keyboard.next();
                if(name.equals("Q"))
                    done = true;
                else{
                    try {
                        Object value = r1.find(name);
                        r1.remove(name);
                        r2.insert(name, (long)value);
                    } catch (DictionaryItemNotFoundException e) {
                        System.err.println("Name " + name + " not found.");
                    }
                }
            }            
        }

        keyboard.close();

        try{
            PrintWriter file = new PrintWriter(args[1]);

            file.print(r2);

            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File " + args[1] + " not found.");
        }


    }
}


class Rubrica implements Dictionary
{
    //metodi di Rubrica ......da completare ......
    public Rubrica(){
        v = new Pair[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        vSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return vSize == 0;
    }

    @Override
    public void insert(Comparable key, Object value) {
        if(vSize == v.length)
            v = resize(v, v.length);

        if(contains(key))
            remove(key);
        
        v[vSize++] = new Pair((String)key, (long)value);
        insertionSort(v, vSize);
    }

    private Pair[] resize(Pair[] v, int size){
        if(size < v.length)
            throw new IllegalArgumentException();
        
        Pair[] newV = new Pair[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    private boolean contains(Comparable key){
        for(int i = 0; i < vSize; i++)
            if(key.compareTo(v[i].getName()) == 0)
                return true;
        return false;
    }

    private void insertionSort(Pair[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            Pair temp = v[i];

            int j;
            for(j = i; j > 0  && temp.getName().compareTo(v[j - 1].getName()) < 0; j--)
                v[j] = v[j - 1];
            v[j] = temp;
        }
    }

    @Override
    public void remove(Comparable key) {
        int index = binarySearch(v, 0, vSize, key);
        vSize--;
        for(int i = index; i < vSize; i++)
            v[i] = v[i + 1];
        
    }

    @Override
    public Object find(Comparable key) {
        return v[binarySearch(v, 0, vSize, key)].getPhone();
    }

    private int binarySearch(Pair[] v, int from, int to, Comparable key){
        if(from > to)
            throw new DictionaryItemNotFoundException();

        int mid = (from + to) / 2;
        Comparable midValue = v[mid].getName();

        if(midValue.compareTo(key) == 0)
            return mid;
        if(key.compareTo(midValue) > 0)
            return binarySearch(v, mid + 1, to, key);
        return binarySearch(v, from, mid - 1, key);
    }



    public String toString(){
        String s = "";
        for(int i = 0; i < vSize; i++)
            s += v[i] + "\n";

        return s;
    }

    //campi di esemplare di Rubrica ..... da completare ......
    private Pair[] v;
    private int vSize;
    public static final int INITIAL_SIZE = 100;


    //classe privata Pair: non modificare!!
    private class Pair
    {   public Pair(String aName, long aPhone)
        {   name= aName; 
            phone = aPhone;
        }
        public String getName() 
        {   return name; }
        public long getPhone() 
        {   return phone; }
        /*
            Restituisce una stringa contenente
            - la nome, "name"
            - un carattere di separazione ( : )
            - il numero telefonico, "phone"
        */
        public String toString() 
        {   return name + " : " + phone; }
        //campi di esemplare
        private String name;
        private long phone;
    }
}


interface Dictionary
{
    /*
        verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    boolean isEmpty();
    
    /*
        svuota il dizionario
    */
    void makeEmpty();

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    void insert(Comparable key, Object value);

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    void remove(Comparable key);

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {}
