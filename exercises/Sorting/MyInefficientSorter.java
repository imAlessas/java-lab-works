import java.util.Scanner;

public class MyInefficientSorter {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        final int INITIAL_SIZE = 100;
        int[] data = new int[INITIAL_SIZE];
        int vSize = 0;

        while(keyboard.hasNextInt()){
            data[vSize] = keyboard.nextInt();
            vSize++;
        }

        keyboard.close();

        int[] v = new int[vSize];
        for(int i = 0; i < v.length; i++)
            v[i] = data[i];

          
        System.out.println("Initial");
        for(int value : v)
            System.out.println(value);

        int[] sorted = new int[0];

        
        while(v.length != 0){
            System.out.println("-------------------------");
            int minIndex = findMin(v, vSize);

            int min = v[minIndex];
            System.out.println("Minimo: " + min);

            sorted = sortedArray(sorted, sorted.length, min);

            System.out.println("\nSorted");
            for(int value : sorted)
                System.out.println(value);


            v = removeMin(v, vSize, minIndex);
            vSize--;

            System.out.println("\nNew V");
            for(int value : v)
                System.out.println(value);
        }


        System.out.println("\n\n\nSorted");
        for(int value : sorted)
            System.out.println(value);
    }

    private static int findMin(int[] v, int vSize){
        int min = v[0];
        int index = 0;

        for(int i = 1; i < vSize; i++)
            if(v[i] < min){
                index = i;
                min = v[i];
            }
        
        return index;
    }

    private static int[] sortedArray(int[] v, int vSize, int min){
        int[] newV = new int[vSize + 1];
        System.arraycopy(v, 0, newV, 0, vSize);
        newV[vSize] = min;

        return newV;
    }

    private static int[] removeMin(int[] v, int vSize, int min){
        
        int[] newV = new int[vSize - 1];
        for(int i = 0; i < vSize - 1; i++)
            if(i >= min){
                newV[i] = v[i+1];
            } else{
                newV[i] = v[i];
            }

        return newV;
    }
}
