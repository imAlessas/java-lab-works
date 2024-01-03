public class SelectionSort {
    
    public static void main(String[] args) {
        final int SIZE = 1000; // con un milione ci mette poco più di 3 minuti
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(10000);

        long before = System.currentTimeMillis();

        selectionSort(numbers, numbers.length);
        
        long time = System.currentTimeMillis() - before;

        System.out.println(time);

        // print(numbers);

    }

    public static void selectionSort(int[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            // trovo la posizione del minimo tra I e vSize
            int minPos = findMinPosition(v, vSize, i);
            // swappo v[i], ovvero la prima cella non ordinata disponibile
            // con v[min] ovvero il valore minimo dell'array disordinato
            swap(v, minPos, i);
        }
    }

    private static int findMinPosition(int[] v, int vSize, int from){
        int min = v[from], minPos = from;
        for(int i = from + 1 ; i < vSize; i++)
            if(v[i] < min){ // mi salvo il minimo
                min = v[i];
                minPos = i;
            }
        
        return minPos;
    }

    private static void swap (int[] v, int min, int first){
        int temp = v[first];
        v[first] = v[min];
        v[min] = temp;
    }

    public static void print(int[] v){
        for(int value : v)
            System.out.println(value);
    }


}