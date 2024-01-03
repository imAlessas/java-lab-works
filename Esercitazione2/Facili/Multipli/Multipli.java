import java.util.Scanner;

public class Multipli {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Inserisci il multiplo e il limite massimo: ");
        int n = keyboard.nextInt();
        int max = keyboard.nextInt();

        keyboard.close();

        for(int i = 1; max >= n ; i++){
            System.out.print(n*i + " ");
            max -= n;
        }
    }
}
