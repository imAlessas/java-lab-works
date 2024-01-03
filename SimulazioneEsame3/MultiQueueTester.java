import java.util.Scanner;

// nome e cognome del candidato, matricola, data, numero della postazione


public class MultiQueueTester{
    public static void main(String[] args){
        if(args.length != 1){
            System.err.println("Invalid parameter.");
            System.exit(1);
        }

        final int N = Integer.parseInt(args[0]);
        ArrayMultiQueue code = new ArrayMultiQueue(N);

        Scanner file = new Scanner(System.in);

        while(file.hasNext()){
            boolean done = false;
            while(!done){
                String choice = file.next();
                switch(choice){
                    case "A":
                        System.out.println("Inserire il numero della persona da aggiungere: ");
                        String name = file.next();
                        code.add(name);
                        System.out.println("Aggiunto " + name);
                        break;

                    case "R":
                        int nCoda = Integer.parseInt(file.next());
                        System.out.println("Rimosso " + code.remove(nCoda));
                        break;

                    case "P":
                        System.out.println(code);
                        break;

                    case "Q":
                        done = true;
                        break;

                    default:
                        System.err.println("Invalid input.");
                        break;
                }
                System.out.println();
            }
        }



        file.close();
    }
}


//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia Queue usando un array (array riempito
// solo in parte, oppure array riempito solo nella parte centrale, oppure
// array circolare), con o senza ridimensionamento. La classe sovrascrive 
// il metodo toString
// ....... da completare ............

class ArrayQueue implements Queue
{
    //metodi pubblici dell'interfaccia Queue ......da completare ......
    // ...

    public ArrayQueue(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        front = back = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == back;
    }

    @Override
    public int size() {
        if(isEmpty())
            return 0;
        if(front < back)
            return back - front;
        return v.length - front + back;
    }

    private int increment(int index){
        return (index + 1) % v.length;
    }

    @Override
    public void enqueue(Object obj) {
        if(increment(back) == front){
            v = resize(v, 2*v.length);
            if(back < front){
                System.arraycopy(v, 0, v, v.length/2, back);
                back += v.length/2;
            }
        }
        v[back] = obj;
        back = increment(back);       
    }

    private static Object[] resize(Object[] v, int size){
        if(size < v.length)
            throw new IllegalArgumentException();
        
        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override
    public Object getFront() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return v[front];
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        Object obj = getFront();
        front = increment(front);
        return obj;
    }


    //metodo toString ..... da completare .........
    public String toString(){
        String s = "";
        if(back < front){
            for(int i = front; i < v.length; i++)
                s += v[i] + "\n";
            for(int i = 0; i < back; i++)
                s += v[i] + "\n";
        } else
            for(int i = front; i < back; i++)
                s += v[i] + "\n";
        
        return s;
    }          

    private Object[] v;
    private int front, back;
    public static final int INITIAL_SIZE = 100;
}


//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia MultiQueue usando un array di N code. 
// La classe sovrascrive il metodo toString
// ....... da completare ............

class ArrayMultiQueue implements MultiQueue
{
    //costruttore ......da completare ......
    // crea una multicoda vuota, costituita da una sequenza di N code vuote,
    // con N > 0
    public ArrayMultiQueue(int N){
        if(N < 0)
            throw new IllegalArgumentException();
        v = new ArrayQueue[N];
        for(int i = 0; i < N; i++)
            v[i] = new ArrayQueue();

        makeEmpty();
    }          
    
    //metodi pubblici dell'interfaccia MultiQueue ......da completare ......
    // ...
    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for(int i = 0; i < v.length; i++)
            empty = empty && v[i].isEmpty();
        return empty;
    }

    @Override
    public void makeEmpty() {
        for(int i = 0; i < v.length; i++)
            v[i].makeEmpty();        
    }

    @Override
    public void add(Object obj) {
        int minPos = 0, minSize = v[0].size();
        for(int i = 1; i < v.length; i++)
            if(v[i].size() < minSize){
                minSize = v[i].size();
                minPos = i;
            }
        v[minPos].enqueue(obj);
    }

    @Override
    public Object remove(int i) throws EmptyQueueException {
        if(v[i].isEmpty())
            throw new EmptyQueueException();
        if( i > v.length || i < 0)
            throw new IllegalArgumentException();
        return v[i].dequeue();
    }
    

    //metodo toString ..... da completare .........
    public String toString(){
        String s = "";
        for(int i = 0; i < v.length; i++)
            s += "----- CODA " + i + " -----\n" + v[i];
        
        return s;
    }          

    private ArrayQueue[] v;
}

//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto coda

interface Queue
{   // Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    boolean isEmpty(); 

    // Svuota la coda
    void makeEmpty();
  
    // Restituisce il numero di elementi presenti nella coda
    int size();

    // Inserisce l'oggetto obj nella coda
    void enqueue(Object obj);

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    Object dequeue() throws EmptyQueueException;

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    Object getFront() throws EmptyQueueException;
}

//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Eccezione lanciata da dequeue e getFront quando la coda e` vuota

class EmptyQueueException extends RuntimeException { }


//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto "multicoda".
// Una multicoda e` una sequenza di N code. Ciascuna delle N code e` 
// identificata da un indice intero i, dove 0 <= i < N.

interface MultiQueue     
{
    // Restituisce true se la multicoda e` vuota, cioe` se tutte le N
    // code della multicoda sono vuote. Restituisce false se la multicoda
    // contiene almeno un elemento, cioe` se almeno una delle N code della
    // multicoda contiene almeno un elemento
    boolean isEmpty(); 

    // Svuota la multicoda, cioe` svuota tutte le N code della multicoda
    void makeEmpty();
  
    // Inserisce l'oggetto obj nella multicoda. Tra tutte le N code della
    // multicoda, l'oggetto viene accodato a quella che contiene il minor
    // numero di elementi. Nel caso in cui piu` code contengano un numero
    // di elementi pari al minimo, la scelta è indifferente
    void add(Object obj);

    // Disaccoda dalla i-esima coda il suo primo elemento e lo restituisce.
    // L'indice intero i specifica quale e` la coda da cui disaccodare il 
    // primo elemento. Di conseguenza i deve essere tale che 0 <= i < N.
    // Lancia EmptyQueueException se la la i-esima coda e` vuota
    Object remove(int i) throws EmptyQueueException;
}

