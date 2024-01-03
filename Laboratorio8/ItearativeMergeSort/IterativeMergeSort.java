public class IterativeMergeSort {
    public static void main(String[] args) {
        final int SIZE = 10;
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(10000);

        long before = System.currentTimeMillis();

        iterativeMergeSort(numbers, numbers.length);
        
        long time = System.currentTimeMillis() - before;

        System.out.println(time);

        // print(numbers);
    }

    public static void iterativeMergeSort(int[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            
        }
    } 




    public static void print(int[] v){
        for(int value : v)
            System.out.println(value);
    }
}
