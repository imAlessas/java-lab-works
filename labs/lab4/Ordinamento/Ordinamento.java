package Esercizio1; //altrimenti mi dà errore
/*
Scrivere un programma che

chiede all'utente di inserire tre stringhe (una per riga)
visualizza le stringhe in ordine lessicografico crescente (una per riga)
*/

import java.util.Scanner;
public class Ordinamento{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Inserisci una parola: ");
        String s1= in.nextLine();
        System.out.print("Inserisci un'altra parola: ");
        String s2= in.nextLine();
        System.out.print("Inserisci una terza parola: ");
        String s3= in.nextLine();
        in.close();

        String max=null, middle=null, min=null;

        if(s1.compareTo(s2)>=0 && s1.compareTo(s3)>=0){
            max=s1;
            if(s2.compareTo(s3)>=0){
                middle=s2;
                min=s3;
            }else{
                min=s2;
                middle=s3;
            }
        }else if(s2.compareTo(s1)>=0 && s2.compareTo(s3)>=0){
            max=s2;
            if(s1.compareTo(s3)>=0){
                middle=s1;
                min=s3;
            }else{
                min=s1;
                middle=s3;
            }
        }else if(s3.compareTo(s1)>=0 && s3.compareTo(s2)>=0){
            max=s3;
            if(s1.compareTo(s2)>=0){
                middle=s1;
                min=s2;
            }else{
                min=s1;
                middle=s2;
            }
        }

        System.out.print(min+"\n"+middle+"\n"+max);
        
    }
}