import java.util.Scanner;

public class Sottostringa{
    public static void main(String[] args) {
        // substring con lentgh() e charAt()
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ti chiederò di inserire due stringhe e ti dirò se la seconda è una sottostringa della prima.");

        System.out.print("Inserisci la prima stringa: ");
        String s1 = keyboard.nextLine();

        System.out.print("Inserisci la seconda stringa: ");
        String s2 = keyboard.nextLine();
        
        keyboard.close();

        boolean check = false;

        if(s1.length()>s2.length()){
            if(s2.length()!=0){
                for(int i=0; i<s1.length(); i++){
                    if(s1.charAt(i) == s2.charAt(0)){
                        check=true;
                        for(int j=1; j<s2.length(); j++){                        
                            if(s1.length() > (i+j) && s1.charAt(i+j) == s2.charAt(j))
                                check = check && true;
                            else
                                check = false;
                        }
                    } 
                }
                if(check)
                    System.out.println("La stringa '" + s2 + "' e' contenuta nella stringa '" + s1 + "'.");
                else
                    System.out.println("La stringa '" + s2 + "' NON e' contenuta nella stringa '" + s1 + "'.");
                    
            }else System.out.println("La seconda stringa, in quanto vuota, è sottostringa della prima.");
        }else System.out.println("La seconda stringa non può essere una sottostringa della prima in quanto contiene più cratteri.");
    }
}