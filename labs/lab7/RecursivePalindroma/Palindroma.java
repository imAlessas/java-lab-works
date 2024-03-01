import java.util.Scanner;

public class Palindroma {

    private static boolean isPalindroma(String s){
        s = prepare(s);

        return recPalindroma(s);
    }

    //tengo solo le lettere
    private static String prepare(String s){
        s = s.toLowerCase();
        String appoggio = "";
        
        for(int i = 0; i < s.length(); i++)
            if(Character.isLetter(s.charAt(i)))
                appoggio += s.charAt(i);

        return appoggio;
    }

    private static boolean recPalindroma(String s){
        if(s.length() < 2)
            return true;

        if(s.charAt(0) != s.charAt(s.length()-1))
            return false;

        return recPalindroma(s.substring(1, s.length()-1));
    }

    public static void main(String[] args) {
        String word;
        if(args.length == 1)
            word = args[0];
        else{
            Scanner keyboard = new Scanner(System.in);

            System.out.print("Inster a strnig and I'll check if it's palindrome: ");
            word = keyboard.nextLine();

            keyboard.close();
        }

        if(isPalindroma(word))
            System.out.println("The string is palindrome.");
        else
            System.out.println("The string is NOT palindrome.");
    }
}
