import java.util.Scanner;

public class TextContainer{

    private String[] v;
    private int vSize;
    public static final int INITIAL_SIZE = 100;

    /*
    costruttore di un contenitore di testo vuoto
    */
    public TextContainer(){
        v = new String[INITIAL_SIZE];
        vSize = 0;
    }

    /*
      verifica se il testo e` vuoto, restituisce
      true se l'oggetto non contiene testo, false altrimenti
    */
    public boolean isEmpty(){
        return vSize == 0;
    }

    /*
      aggiunge la stringa "stringa" in coda al testo. Termina senza errori
      se String stringa e` uguale a null.
    */
    public void add(String stringa){
        if(vSize == v.length)
            v = resize(v, 2*v.length);
        
        v[vSize++] = stringa;
    }

    private String[] resize(String[] v, int size){
        String[] newArray = new String[size];
        System.arraycopy(v, 0, newArray, 0, v.length);

        return newArray;
    }

    /*
     conta e restituisce il numero di stringhe nel testo
    */
    public int count(){
        return vSize;
    }

    /*
     separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
     TextContainer in cui tutte le parole sono separate, e ne restituisce il
     riferimento. Usa l'insieme di delimitatori di default di Scanner, ovvero
     "\p{JavaWhitespace" (si veda la documentazione di Scanner, in particolare
     dei metodi delimiter e useDelimiter, e la documentazione della classe
     Pattern)
    */
    public TextContainer splitWords(){
        TextContainer words = new TextContainer();
        for(int i = 0; i < vSize; i++){
           Scanner lineReader = new Scanner(v[i]);
            while(lineReader.hasNext())
                words.add(lineReader.next());
            lineReader.close();
        }
        return words;
    }

    /*
     separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
     TextContainer in cui tutte le parole sono separate, e ne restituisce il
     riferimento. Usa l'insieme di delimitatori specificato dalla stringa delim
     (si veda la documentazione di Scanner, in particolare dei metodi delimiter
     e useDelimiter, e la documentazione della classe Pattern)
    */
    public TextContainer splitWords(String delim){
        TextContainer words = new TextContainer();
        for(int i = 0; i < vSize; i++){
            Scanner lineReader = new Scanner(v[i]);
            lineReader.useDelimiter(delim);
            while(lineReader.hasNext())
                words.add(lineReader.next());
            lineReader.close();
        }
        return words;
    }

    /*
     Rimuovi tutte le occorrenze della stringa "stringa".
     - Se la stringa compare piu` volte vengono eliminate tutte le occorrenze.
     - Lancia IllegalArgumentException se il parametro esplicito e` null.
     Attenzione: si devono scandire tutte le stringhe del testo perche`
     la parola da cancellare puo` comparire piu` volte nel testo.
    */
    public void remove(String stringa){
        if(stringa == null)
            throw new IllegalArgumentException();

        for(int i = 0; i < vSize; i++)
            if(v[i].equals(stringa)){
                remove(v, i);
                i--; // dato che scorro l'array indietro di uno, accadrebbe che una line non sarebbe letta se quella prima viene elimiata
            }
    }

    private void remove(String[] v, int pos){
        for(int i = pos; i < vSize - 1; i++)
            v[i] = v[i + 1]; 
            
        vSize--;
    }

    /*
      Restituisce il numero di occorrenze nel testo della stringa "stringa".
      Lancia IllegalArgumentException se il parametro esplicito e` null.
    */
    public int frequency(String stringa){
        if(stringa == null)
            throw new IllegalArgumentException();

        int count = 0;
        for(int i = 0; i < vSize; i++)
            if(v[i].equals(stringa))
                count++;
        
        return count;
    }

    /*
      restituisce la stringa che compare piu` volte nel testo (frequenza massima).
      Se piu` stringhe hanno frequenza massima, ne restituisce una qualsiasi.
      Se il testo e` vuoto restituisce null.
    */
    public String maxFrequency(){
        if(isEmpty())
            return null;
        
        String max = v[0];
        for(int i = 0; i < vSize; i++)
            if(frequency(max) < frequency(v[i]))
                max = v[i];

        return max;
    }

    /*
      restituisce la prima stringa del testo in ordine lessicografico.
      Se il testo e` vuoto restituisce null.
    */
    public String min(){
        if(isEmpty())
            return null;

        String min = v[0];
        for(int i = 0; i < vSize; i++)
            if(min.compareTo(v[i]) > 0)
                min = v[i];
                
        return min;
    }

    /*
      restituisce l'ultima stringa del testo in ordine lessicografico.
      Se il testo e` vuoto restituisce null.
    */
    public String max(){
        if(isEmpty())
            return null;

        String max = v[0];
        for(int i = 0; i < vSize; i++)
            if(max.compareTo(v[i]) < 0)
                max = v[i];
                
        return max;
    }

    /*
      trasforma il testo in stringa. Viene inserito un carattere di nuova riga (\n)
      fra le stringhe. Se il testo e` vuoto restituisce la stringa vuota "".
    */
    public String toString(){
        String s = "";
        for(int i = 0; i < vSize; i++)            
            s += v[i] + "\n";
        
        return s;
    }

    /*
      crea un nuovo oggetto di tipo TextContainer in cui tutti i caratteri non
      alfabetici sono stati eliminati dalle stringhe del testo. Ad esempo elimina
      la punteggiatura, i numeri, le parentesi. Usa il metodo
      java.lang.Character.isLetter(char c)
    */
    public TextContainer onlyLetters(){
        TextContainer onlyLetters = new TextContainer();

        for(int i = 0; i < vSize; i++){
            String line = "";
            for(int j = 0; j < v[i].length(); j++)
                if(Character.isLetter(v[i].charAt(j)))
                    line += v[i].charAt(j);
            
            onlyLetters.add(line);
        }

        return onlyLetters;
    }

    /*
     crea un nuovo oggetto di tipo TextContainer nel quale tutti i caratteri
     maiuscoli sono stati convertiti in minuscoli.
    */
    public TextContainer toLowerCase(){
        TextContainer lower = new TextContainer();
        for(int i = 0; i < vSize; i++)
            lower.add(v[i].toLowerCase());
        
        return lower;
    }

    /*
     crea una copia dell'oggetto TextContainer, e ne restituisce il riferimento
    */
    public TextContainer copy(){
        TextContainer copy = new TextContainer();
        for(int i = 0; i < vSize; i++)
            copy.add(v[i]);

        return copy;
    }

}