package Esercizio5;

import java.util.Scanner;

public class Palindroma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci una stringa e ti dirò se è palindroma: ");
        String s= input.nextLine();
        
        input.close();

        boolean flag=false;
        int i=0;
        if(s.length()!=0){
            do{
                if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                    flag=true;
                    System.out.println("La stringa non e' palindroma");
                }
                i++;
            }while(!flag && i<Math.round(s.length()/2));
        }

        if(!flag) System.out.println("La stringa e' palindroma");
    }
}
