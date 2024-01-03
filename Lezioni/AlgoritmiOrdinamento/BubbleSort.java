public class BubbleSort {
    public static void main(String[] args) {
        final int SIZE = 100000; // con un 100000 ci mette circa 21 secondi, con un milione può metterci anche più di mezz'ora
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(10000);

        long before = System.currentTimeMillis();
        // recBubbleSort(numbers, numbers.length);

        bubbleSort(numbers, numbers.length);

        long time = System.currentTimeMillis() - before;
        System.out.println(time);

        // print(numbers);
    }

    // con i numeri molto alti (>10000) dà StackOverflow error
    public static void recBubbleSort(int[] v, int vSize){
        if(isSorted(v, vSize))
            return;

        for(int i = 0; i < vSize - 1; i++)
            if(v[i] > v[i + 1])
                swap(v, i, i + 1);

        recBubbleSort(v, vSize);
    }



    private static boolean isSorted(int[] v, int vSize){
        for(int i = 0; i < vSize - 1; i++)
            if(v[i] > v[i + 1])
                return false;
        return true;
    }


    

    public static void bubbleSort(int[] v, int vSize){
        boolean done = false;
        while(!done){
            done = true;
            for(int i = 0; i < vSize - 1; i++)
                if(v[i] > v[i + 1]){
                    // se fa almeno uno swap vuol dire che 
                    // l'array deve ancora essere ordinato del tutto
                    swap(v, i, i + 1);
                    done = false;
                }
        }
    }

    private static void swap(int[] v, int pos1, int pos2){
        int temp = v[pos1];
        v[pos1] = v[pos2];
        v[pos2] = temp;
    }

    

    private static void print(int[] v){
        for(int value : v)
            System.out.println(value);
    }
}
