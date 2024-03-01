package Esercizio2;

import java.util.Scanner;

public class AppUguali{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        double n= in.nextDouble();

        System.out.print("Inserisci un secondo numero: ");
        double m= in.nextDouble();

        in.close();

        if(Math.abs(Math.round(n*100) - Math.round(m*100))<1)
            System.out.println("I due numeri sono approssimativamente uguali.");
        else
            System.out.println("I due numeri non sono approssimativamente uguali.");
    }
}