public class BogoSort {
    public static void main(String[] args) {
        final int SIZE = 13; 
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(10000);

        print(numbers);
        long before = System.currentTimeMillis();

        bogoSort(numbers, numbers.length);

        System.out.println("-----");
        long time = System.currentTimeMillis() - before;
        System.out.println("Tempo impiegato:"+ time);

        print(numbers);
    }

    private static void bogoSort(int[] v, int vSize){
        java.util.Random generator = new java.util.Random();
        while(!isSorted(v, vSize)){
            int pos1 = generator.nextInt(vSize);
            int pos2 = generator.nextInt(vSize);
            swap(v, pos1, pos2);
        }
    }


    private static boolean isSorted(int[] v, int vSize){
        for(int i = 0; i < vSize - 1; i++)
            if(v[i] > v[i + 1])
                return false;
        return true;
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
