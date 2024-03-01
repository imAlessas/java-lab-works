public class ItareativeBinSearch {
    public static void main(String[] args) {
        final int SIZE = 10; 
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(5); 
        
        insertionSort(numbers, numbers.length);

        for(int value : numbers)
            System.out.println(value);

        int pos = itareativeBinarySearch(numbers, numbers.length, 0);
        if(pos > 0)
            System.out.println("Posizione " + pos + ": " + numbers[pos]);
        else
            System.out.println("Value non found");

    }

    public static int itareativeBinarySearch(int[] v, int vSize, int value){
        int pos = 0, from = 0, to = vSize - 1;
        boolean done = false;
        
        while( from < to && !done){
            int mid = (from + to)/2;
            int midValue = v[mid];

            if(midValue == value){
                pos = mid;
                done = true;
            }

            if(value < midValue)
                to = mid -1;
            else
                from = mid +1;
        }
        return pos;
    }

    private static void insertionSort(int[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            int temp = v[i];
            int j;

            for(j = i; j > 0 && temp < v[j -1]; j--)
                v[j] = v[j - 1];
            v[j] = temp;
        }
    }
}
