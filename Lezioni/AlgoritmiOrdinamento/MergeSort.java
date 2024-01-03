public class MergeSort {
    
    public static void main(String[] args) {
        final int SIZE = 10; // con 10 milioni ci mette poco più di due secondi
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(10000);

        long before = System.currentTimeMillis();

        mergeSort(numbers, numbers.length);
        
        long time = System.currentTimeMillis() - before;

        System.out.println(time);

        // print(numbers);

    }

    public static void mergeSort(int[] v, int vSize){
        if(vSize < 2) // se un array ha un solo elemento, per definizione è ordinato
            return;
        
        // trovo l'indice medio
        int mid = vSize/2;

        // creo due array che conterranno la prima e la seconda metà di v
        int[] left = new int[mid];
        int[] right = new int[vSize - mid]; // necessario vSize - mid per le lunghezze dispari

        // copio la prima e la seconda metà di v nei due array
        System.arraycopy(v, 0, left, 0, mid);
        System.arraycopy(v, mid, right, 0, vSize - mid);

        // passo ricorsivo
        mergeSort(left, mid);
        mergeSort(right, vSize - mid);

        // unisco i valori dei due array su quello originale
        merge(v, left, right);
    }

    private static void merge(int[] v, int[] left, int[] right){
        int vIndex = 0, leftIndex = 0, rightIndex = 0;
        
        // finche non finisco i valori su uno o sull'altro array continuo ad iterare
        while(leftIndex < left.length && rightIndex < right.length)
            if(left[leftIndex] < right[rightIndex]) // salvo il minore dei due valori in v
                v[vIndex++] = left[leftIndex++];
            else
                v[vIndex++] = right[rightIndex++];
        
        // i due while servono nel caso siano rimasti ancora dei valori su uno dei due array
        // non sapendo quale dei due sia faccio il while su entrambi
        while(leftIndex < left.length)
            v[vIndex++] = left[leftIndex++];

        while(rightIndex < right.length)
            v[vIndex++] = right[rightIndex++];  
    }

    private static void print(int[] v){
        for(int value : v)
            System.out.println(value);
    }

}
