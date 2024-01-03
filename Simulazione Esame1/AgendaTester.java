import java.util.Scanner;

// Trigolo Alessandro, 2043049, 09/12/2021, casa

public class AgendaTester{   
    public static void main(String[] args){
        Agenda agenda = new Agenda();

        Scanner keyboard = new Scanner(System.in);
        String choice;
        char letter;
        boolean done = false;

        do{
            menu();
            choice = keyboard.nextLine();
            letter = choice.toUpperCase().charAt(0);

            switch(letter){
                case 'I':
                    System.out.println("Inserisci un impegno nella formula (chiave, valore). Per esempio '0 Studiare ricorsione'.");
                    String s = keyboard.nextLine();

                    Scanner token = new Scanner(s);
                    int key = Integer.parseInt(token.next());

                    agenda.insert(key, token.next());

                    break;

                case 'R':
                    agenda.removeMin();
                    break;

                case 'L':
                    System.out.println(agenda.getMin());
                    break;

                case 'Q': 
                    done = true;
                    break;

                default:
                    System.out.println("Comando non valido.");
                    break2;
            }
        }while(!done);

        keyboard.close();
    }

    private static void menu(){
        System.out.println("--------------------");
        System.out.println(" 'I'  Inserisci un impegno.");
        System.out.println(" 'R'  Rimuovo il primo impegno della priorità massima.");
        System.out.println(" 'L'  Mostro il primo impegno di priorità massima.");
        System.out.println(" 'Q'  Termina il programma.");
        System.out.println("--------------------");
        System.out.print("La tua scelta: ");
    }
}

class Agenda implements PriorityQueue{

    private Impegno[] v;
    private int vSize;
    // non ha senso mettere 0 (resize sarebbe sempre 0) 
    // tantomeno nimeri molto piccoi altimenti il resize verrebbe invocato troppo spesso
    private static final int INITSIZE = 100; 

    // il testo non mi dice di fare costruttori particolari, quindi faccio quello vuoto.
    public Agenda(){
        this.v = new Impegno[INITSIZE]; //ogni cella è un riferimento a Impegno, ma per ora è NULL
        this.vSize = 0; // indice che mi dice qual è la prima cella disponibile
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < vSize; i++)
            s+= v[i] + "\n";
        return s;
    }

    public void makeEmpty(){
        // "svuota" l'array
        // in realtà dice che tutte le celle dell'array sono sovrascrivibili
        this.vSize = 0;
    }

    public boolean isEmpty(){
        return this.vSize == 0;
    }

    public void insert(int key, Object value){
        if(this.vSize == v.length)
            resize(vSize * 2);
        
        v[vSize] = new Impegno(key, (String)value);
        vSize++;
    }

    private void resize(int l){
        Impegno[] newV = new Impegno[l];
        
        // Prendo v alla prima cella e scorro v per vSize volte in newV a partire da 0
        System.arraycopy(v, 0, newV, 0 ,vSize);

        v = newV;
    }

    // implemento questo metodo perchè mi serve sia in getMin() che in removeMin()
    // restituiscie il primo impegno di priorità 0, ovvero priorità massima
    private int getMinPos(){
        if(isEmpty())
            throw new EmptyQueueException();

        for(int i = 0; i < vSize; i++)
            if(v[i].getPriority() == 0)
                return i;
        return -1;
    }
    
    public Object getMin() throws EmptyQueueException{
        int minPos = getMinPos();
        if(minPos > -1)
            return v[minPos].getMemo();
        else return null;
    }

    public Object removeMin() throws EmptyQueueException{
        int minPos = getMinPos();
        if(minPos > -1){
            Object minImp = v[minPos].getMemo();
            // dato che l'array non deve essere ordinato, prendo l'ultimo elemnto dell'array e lo metto al psoto di quello da rimuovere
            // in secondo luogo decremento la lunghezza dell'array escoludendo così l'ultimo elemento (che l'ho già messo al posto di quello rimosso)
            v[minPos] = v[--vSize];
            return minImp;
        }
        return null;
    }


    /*
        classe privata Impegno: rappresenta gli elementi della classe Agenda ed
        e` costituita da coppie "chiave valore" in cui il campo chiave e` di
        tipo int e rappresenta la priorita` dell'impegno, e il campo valore e`
        una stringa contenente un promemoria dell'impegno. Si considerano 4 
        livelli di priorita`, numerati da 0 a 3. Conseguentemente il campo 
        chiave puo` assumere valori solo in questo intervallo, dove il valore 0  
        significa "massima priorita`" e il valore 3 significa "minima priorita`" 
    */
    private class Impegno //non modificare!!
    {   public Impegno(int priority, String memo)
        {   if (priority>3 || priority<0) throw new IllegalArgumentException();
            this.priority = priority;
            this.memo = memo;
        }
        // metodi (pubblici) di accesso
        public int getPriority()
        {   return priority; }
        public Object getMemo()
        {   return memo; }
        //metodo toString sovrascritto
        public String toString()
        {   return priority + " " + memo; }
        //campi di esemplare (privati) della classe Impegno
        private int priority; //priorita` dell'impegno (da 0 a 3)
        private String memo; //promemoria dell'impegno
    }    
}


/*  
    Interfaccia PriorityQueue (non modificare!!). 
    - Questo tipo di dato astratto definisce un contenitore di coppie 
      "chiave valore", dove il campo chiave e` un numero in formato int che 
      specifica il livello di priorita` della coppia mentre il campo valore 
      rappresenta il dato della coppia. 
    - Si assume che date due chiavi k1 e k2 tali che k1 < k2, allora k1 ha 
      priorita` piu` alta di k2.
    - Naturalmente possono essere presenti nel contenitore coppie diverse con 
      chiavi uguali, cioe` con uguale priorita`
*/
interface PriorityQueue //non modificare!!
{   /*
        svuota la coda di priorita`
    */
    void makeEmpty();
  
    /*
        restituisce true se la coda e' vuota, false altrimenti
    */
    boolean isEmpty();

    /*
        Metodo di inserimento
        Inserisce la coppia "chiave valore" nella coda di priorita`. Notare che 
        la coda di priorita` puo` contenere piu` coppie con la stessa chiave.
        Questo perche` il campo chiave non serve ad identificare univocamente
        un elemento (come nel caso di un dizionario), ma serve invece a definire
        la priorita` di un elemento. E` ovvio che piu` elementi possono avere 
        la stessa priorita`. 
    */
    void insert (int key, Object value);

    /*
        Metodo di rimozione
        Rimuove dalla coda la coppia con chiave minima, e restituisce un 
        riferimento al suo campo value. Se sono presenti piu` coppie con chiave
        minima, effettua la rimozione di una qualsiasi delle coppie con chiave 
        minima (ad es. la prima coppia con chiave minima che e` stata trovata)
        Lancia EmptyQueueException se la coda di priorita` e` vuota
    */
    Object removeMin() throws EmptyQueueException;

    /*
        Metodo di ispezione
        Restituisce un riferimento al campo value della coppia con chiave minima
        (ma *non* rimuove la coppia dalla coda).  Se sono presenti piu` coppie 
        con chiave minima, restituisce il campo value di una qualsiasi delle   
        coppie con chiave minima (ad esempio la prima coppia con chiave minima 
        che e` stata trovata). Lancia EmptyQueueException se la coda e` vuota
    */
    Object getMin() throws EmptyQueueException;
}

/*
    Eccezione lanciata dai metodi removeMin e getMin di PriorityQueue quando
    la coda di priorita` e` vuota 
*/
class EmptyQueueException extends RuntimeException {}
