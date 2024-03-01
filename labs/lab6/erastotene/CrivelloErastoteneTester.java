import java.util.Scanner;

public class CrivelloErastoteneTester {

    private static void show(boolean[] numbers){
        for(boolean n : numbers)
            System.out.println(n);
    }

    private static boolean isPrime(int number){
        if(number == 0)
            return false;

        for(int i=2; i< number-1; i++)
            if(number%i ==0)
                return false;

        return true;
    }

    private static String crivelloErastotene(boolean[] numbers){
        String s = "";
        for(int i = 0; i < numbers.length; i++){
            if(isPrime(i)){
                numbers[i] = false;
                s += i + " ";
            }
        }  
        return s;

    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the number of elements: ");
        int elements = keyboard.nextInt();

        keyboard.close();

        boolean[] numbers = new boolean[elements];
        for(int i=0; i<numbers.length; i++)
            numbers[i] = true;
            
        
        System.err.println("Prime numbers: " + crivelloErastotene(numbers));
    }
}
