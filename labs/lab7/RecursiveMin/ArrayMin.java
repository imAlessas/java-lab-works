import java.util.Random;
import java.util.Scanner;

public class ArrayMin {

    private static int min(int[] n){
        return findMin(n, n.length, n[n.length - 1]);
    }

    private static int findMin(int[] n, int size, int min){
        if(size == 0)
            return min;
        
        if(n[size -1] < min)
            min = n[size -1];
        
        return findMin(n, size-1, min);

    }
 
    public static void main(String[] args) {
        int dim, max;
        if(args.length == 2){
            dim = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
        } else {
            Scanner keyboard = new Scanner(System.in);

            System.out.print("Insert the dimension of the array: ");
            dim = keyboard.nextInt();

            System.out.print("Insert the max value of the array: ");
            max = keyboard.nextInt();

            keyboard.close();
        }

        Random generator = new Random();

        int[] randNum = new int[dim];
        for(int i = 0; i < randNum.length;i++){
            randNum[i] = generator.nextInt(max-1) + 1;
            System.out.println(randNum[i]);
        }

        System.out.println("----- Min -----");
        System.out.println(min(randNum));        
    }
}
