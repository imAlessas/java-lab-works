import java.util.Scanner;
import java.util.Arrays;

public class AlgCesare {

    private static String cesareArray(String s, int n){
        char[] alphabet={'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        s=s.toLowerCase();
        String c=""; // risultato della stringa

        for(int i=0; i<s.length(); i++){
            int currentIndex= Arrays.binarySearch(alphabet, s.charAt(i));
            if(currentIndex!= -1)
                c+=alphabet[(n+currentIndex)%26];
            else
                c+=s.charAt(i);
        }
        return c.toUpperCase();
    }

    private static String cesareChar(String s, int n){
        s=s.toLowerCase();
        String c="";
        for(int i=0; i<s.length(); i++){
            char currentChar=s.charAt(i);
            if(currentChar>='a' && currentChar <='z'){
                char shiftedChar = (char)(currentChar + n);
                while(shiftedChar>'z')
                    shiftedChar-=26;
                c+=shiftedChar;
            } else c+=currentChar;
        }
        return c.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Inserisci una stringa: ");
        String s = keyboard.nextLine();

        System.out.print("Chiave di cifratura: ");
        int n = Math.abs(keyboard.nextInt()); 

        keyboard.close();

        System.out.println("Cesare con array: "+cesareArray(s, n));
        System.out.println("Cesare con char: "+cesareChar(s, n));
    }
}
