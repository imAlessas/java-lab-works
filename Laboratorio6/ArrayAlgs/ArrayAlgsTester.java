import java.util.Random;
import java.util.Scanner;

public class ArrayAlgsTester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Insert the number of elements the array should contain: ");
        int n= keyboard.nextInt();

        System.out.print("Insert the minumum value: ");
        int min= keyboard.nextInt();

        System.out.print("Insert the maximum value: ");
        int max= keyboard.nextInt();




        Random generator = new Random();

        int[] numbers = new int[n];
        for(int i=0; i<numbers.length; i++)
            numbers[i] = generator.nextInt(max-min) + min; 
        
        boolean done = false;
        String choice;
        while(!done){
            menu();
            choice = keyboard.next();
            switch(choice){
                case "Q": 
                    done = true;
                    break;
                case "P": 
                    for (int number : numbers) 
                        System.out.println(number);
                    break;
                case "m": 
                    System.out.println("Min value: " + ArrayAlgs.findMin(numbers, numbers.length));
                    break;
                case "M": 
                    System.out.println("Min value: " + ArrayAlgs.findMax(numbers, numbers.length));
                    break;
                case "r": 
                    int i1 = Integer.parseInt(keyboard.next());
                    ArrayAlgs.remove(numbers, numbers.length, i1);
                    break;
                case "R":
                    int i2 = Integer.parseInt(keyboard.next());
                    ArrayAlgs.remove(numbers, numbers.length, i2);
                    break;
                case "I": 
                    int i3 = Integer.parseInt(keyboard.next());
                    int value = Integer.parseInt(keyboard.next());
                    numbers = ArrayAlgs.insert(numbers, numbers.length, i3, value);
                    break;
                default : System.out.println("Invalid input");
                        break;
            }

        }

        keyboard.close();
        
    }  

    private static void menu(){
        System.out.println("---------- Menu ----------");
        System.out.println("Q   -->  Quit");
        System.out.println("P   -->  Print");
        System.out.println("m   -->  min");
        System.out.println("M   -->  Max");
        System.out.println("r i -->  remove index i");
        System.out.println("R i -->  Remove-sorted index i");
        System.out.println("I i v -->Insert v value into i index");
        System.out.println("--------------------------");
        System.out.print("Your choice:  ");
    }
}
