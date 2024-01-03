import java.util.Scanner;

public class Sottosequenza {
    public static void main(String[] args) {
        // subsequence con length() e charAt()
        // gatto è sottosequenza di gratto
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ti chiederò di inserire due stringhe e ti dirò se la seconda è una sottostringa della prima.");

        System.out.print("Inserisci la prima stringa: ");
        String s1 = keyboard.nextLine();

        System.out.print("Inserisci la seconda stringa: ");
        String s2 = keyboard.nextLine();
        
        keyboard.close();

        boolean check = true; 

        if(s2.length()>0){
            int cont1=0;
            int cont2=0;
            while(cont1<s1.length() && cont2<s2.length()){
                //System.out.println("s1: " + s1.charAt(cont1) + "\t\t s2: " + s2.charAt(cont2));
                if(s1.charAt(cont1) == s2.charAt(cont2)){
                    System.out.println("s1: " + s1.charAt(cont1) + "\t\t s2: " + s2.charAt(cont2));
                    check = check && true;
                    cont2++;
                } 
                cont1++;
            }

            if(cont2<s2.length()) // se il contatore è minore della lunghezza vuol dire che non tutti i caretteri di s2 sono stati torvati in s1 
                check=false;

            if(check)
            System.out.println("La stringa '" + s2 + "' e' sottosequenza della stringa '" + s1 + "'.");
            else
                System.out.println("La stringa '" + s2 + "' NON e' sottosequenza della stringa '" + s1 + "'.");
            
        }else System.out.println("La seconda stringa e' sicuramente sottosequenza della prima in quanto contiene 0 caratteri.");
    }
}
