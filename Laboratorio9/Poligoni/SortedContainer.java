import java.util.NoSuchElementException;

public class SortedContainer implements Container{

    private Comparable[] v;
    private int vSize;
    private static final int INITIAL_SIZE = 100;

    //Costruisce un contenitore vuoto
    public SortedContainer(){
         v = new Comparable[INITIAL_SIZE];
         vSize = 0;
    }

    public boolean isEmpty(){
        return vSize == 0;
    }

    public void makeEmpty(){
        vSize = 0;
    }

    /*
        Aggiunge l'elemento compObj, ridimensionando l'array se necessario.
        L'elemento viene inserito in coda all'array e successivamente l'array
        viene ordinato. Andamento asintotico O(n) (prima dell'inserimento 
        l'array e' ordinato!)
    */
    public void add(Comparable compObj){
        if(v.length == vSize)
            v = resize(v, v.length * 2);
        
        v[vSize] = compObj;
        vSize ++;

        insertionSort(v, vSize);        
    }

    private Comparable[] resize(Comparable[] oldAr, int newLength){
        Comparable[] newArray = new Comparable[newLength];
        System.arraycopy(v, 0, newArray, 0, v.length);

        return newArray;
    }

    private static void insertionSort(Comparable[] v, int vSize){
        for(int i = 1; i < vSize; i++){
            Comparable temp = v[i];
            int j;
            for(j = i; j > 0  && temp.compareTo(v[j - 1]) < 0; j--)
                v[j] = v[j - 1];

            v[j] = temp;
        }
    }

    /*
        restituisce il valore massimo del contenitore (massimo nel senso 
        definito dal metodo compareTo()), e lo cancella dal contenitore. 
        Andamento asintotico O(1).
        Lancia NoSuchElementException se l'array e' vuoto
    */
    public Comparable removeMax() throws NoSuchElementException{
        if(vSize == 0)
            throw new NoSuchElementException();

        Comparable temp = v[vSize - 1];
        vSize--;
        return temp;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < vSize; i++)
            s += v[i] + "\n";
        
        return s;
    }
}
