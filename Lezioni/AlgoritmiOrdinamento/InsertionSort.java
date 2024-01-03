public class InsertionSort {
    
    public static void main(String[] args) {
        final int SIZE = 1000000; // con 1 milione di elementi ci mette più di 5 minuti 
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(10000);
            

        long before = System.currentTimeMillis();
        insertionSort(numbers, numbers.length);
        long time = System.currentTimeMillis() - before;
        System.out.println(time);

        // print(numbers);
    }

    /*
        Questo algoritmo di ordinamento è ottimo per ordinare un array che è
        già parzialmente ordinato o meglio, che ad ogni inseriemnto deve essere ordinato nuovamente. 
        Nel caso migliore infatti le sue prestazioni sono N e non NlogN come il mergeSort oppure N^2 come il selection.
    */

    public static void insertionSort(int[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            // salvo il primo valore della parte non ordinata dell'array
            int temp = v[i];

            int j;
            // controllo la parte già ordinata dell'array
            // finchè temp è minore dei numeri della parte ordinata
            // sposto tutti i valori maggiori di temp di una casella a destra
            for(j = i; j > 0 && temp < v[j - 1]; j--) // se i dati sono già ordinati questo for non itera mai
                v[j] = v[j - 1];
            // inserisco temp
            v[j] = temp;
        }
    }

    private static void print(int[] v){
        for(int value : v)
            System.out.println(value);
    }
}