package Esercizio4;

import java.util.Scanner;

public class NumeriPrimi {

    private static boolean primo(int i) {
        int cont = 2;
        while(cont<i){
            if(i%cont == 0) return false;
            cont++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        do{
            System.out.print("Inserisci un numero intero positivo: ");
            n = in.nextInt();
        }while(n<0);

        in.close();

        for(int i=2; i<n; i++){
            if(primo(i)) System.out.println(i);
        }

    }
}
