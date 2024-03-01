package Esercizio3;

import java.util.Scanner;

public class Triangolo {

    private static int maxLato(int a, int b, int c){
        if(a>=b && a>=c) return a;
        else if(b>=a && b>=c) return b;
        else if(c>=a && c>=b) return c;

        return -1;
    }

    private static double angolo(int a, int b, int c){
        int max= maxLato(a, b, c);
        a= Math.abs(a-max);
        b= Math.abs(b-max);
        c= Math.abs(c-max);

        return Math.pow(max, 2) - Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2);
    }

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        System.out.println("Inserisci i 3 alti di un trangolo e questo verrà classificato.");
        System.out.print("Primo lato: ");
        int a= in.nextInt();

        System.out.print("Secondo lato: ");
        int b= in.nextInt();

        System.out.print("Terzo lato: ");
        int c= in.nextInt();

        in.close();

        int max= maxLato(a, b, c);
        int angolo= (int)angolo(a, b, c);

        if(max<=(a+b+c-max)){
            //Lati
            if(a==b && a==c) System.out.print("Triangolo equilatero ");
            else if(a==b || a==c || b==c) System.out.print("Triangolo isoscele "); // Isoscele
            else  System.out.print("Triangolo scaleno "); // Scaleno

            //Angoli
            if(angolo > 0) System.out.println("ottusangolo.");
            else if(angolo < 0) System.out.println("acutangolo.");
            else System.out.println("rettangolo.");

        }else System.out.println("Non e' un triangolo");

    }
}
