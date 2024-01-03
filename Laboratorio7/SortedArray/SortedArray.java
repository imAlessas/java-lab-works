import java.util.NoSuchElementException;

public class SortedArray
{
    private int[] v;
    private int vSize;
    private final static int INITIAL_SIZE = 100;
 
    //Crea un oggetto SortedArray vuoto
    public SortedArray(){
        v = new int[INITIAL_SIZE];
        vSize = 0; 
    }

    //verifica se l'array e` vuoto. Prestazioni O(1)
    public boolean isEmpty(){
        return vSize == 0;
    }

    /* Aggiunge il valore value all'array ordinato, conservando l'ordinamento.
        Prestazioni O(n) (prima dell'inserimento l'array e' ordinato!) */
    public void add(int value){
        if(v.length == vSize)
            resize(2*v.length);

        int i;
        // traslo di un più avanti i valori < di value
        for(i = vSize; i > 0  && value < v[i - 1]; i--)
            v[i] = v [i - 1];

        v[i] = value;
        vSize++;
    }

    private void resize(int size){
        int[] newV = new int[size];
        System.arraycopy(v, 0, newV, 0, vSize);
        v = newV;
    }

    /* Cancella il valore massimo dall'array, e lo restituisce.
        Prestazioni O(1). Lancia NoSuchElementException se l'array e' vuoto */
    public int removeMax() throws NoSuchElementException{ 
        if(isEmpty())
            throw new NoSuchElementException();
        return v[--vSize];        
    }

    /* Restituisce la media (average) dei valori dell'array
        Prestazioni O( n) */
    public double avg(){
        int avg = 0;
        for(int i = 0; i < vSize; i++)
            avg += v[i];
        
        return avg/vSize;
    }

    /* Cerca un numero value nell'array ordinato (ricerca binaria).
        Prestazioni O(log n). Restituisce l'indice nell'array dell'intero 
        value se questo viene trovato, altrimenti restituisce il valore -1 */
    public int search(int value){
        return binarySearch(0, vSize, value);
    }

    private int binarySearch(int from, int to, int value){
        if (from > to) // caso base --> non ho trovato il valore
            return -1; 

        int mid = (from + to) / 2; // trovo la metà dell'array
        int midValue = v[mid]; 

        if (midValue == value)
            return mid; // ritorno la posizione del valore, non il valore
        else if (midValue < value)
            return binarySearch(mid + 1, to, value);
        else 
            return binarySearch(from, mid - 1, value);
        
        // durante la ricorsione il 'mid' diventa il to o il from a seconda di value. 
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < vSize; i++)
            s += v[i] + "\n";
        return s;
    }

}