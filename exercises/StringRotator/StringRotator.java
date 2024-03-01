import java.util.Scanner;

public class StringRotator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Inserisci la stringa: ");
        String line = keyboard.nextLine();

        System.out.print("Inserisci il numero di caratteri da girare: ");
        int n = keyboard.nextInt();
        boolean isPositive = n > 0;
        n = Math.abs(n % line.length());

        keyboard.close();

        // trasferisco la stringa su un array di caratteri
        char[] s = new char[line.length()];
        for(int i = 0; i < s.length; i++)
            s[i] = line.charAt(i);  
        
        // eseguo la rotazione
        char[] r = new char[line.length()];
        for(int i = 0; i < r.length; i++){
            if(isPositive)
                r[(i + n) % r.length] = s[i];
            else
                r[i] = s[(i + n) % r.length];            
        }

        // riporto da array da caratteri ad una stringa
        String rotated = "";
        for(int i = 0; i < r.length; i++)
            rotated += r[i];

        System.out.println(rotated);


    }

}
