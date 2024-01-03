import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversione{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Inserisci un numero compreso tra 0 e 127: ");
        int n = keyboard.nextInt();

        keyboard.close();


        System.out.println(n + " in base 10 e' pari a 0b" + converti(n) + " in base 2.");
    }

    private static String converti(int n){
        if(n > 127)
            throw new InputMismatchException();

        String s = "";
        int i = 0;

        while(n != 0){
            if(i == 4){
                s += "_";
                i = 0;
            }
            
            i++;
            s += n%2;
            n = n/2;
        }

        return format(8, reverse(s));
    }

    private static String reverse(String s){
        if(s.length() == 0)
            return "";
        
        return s.substring(s.length()-1, s.length()) + reverse(s.substring(0, s.length()-1));
    }

    private static String format(int n, String s){
        int i = s.length();

        while(i <= n){
            s = "0" + s;
            i++;
        }
        
        return s;
    }
}