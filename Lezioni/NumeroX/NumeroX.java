import java.util.Scanner;
import java.util.Random;

public class NumeroX{
	public static void main(String[] args) {
		Random generator= new Random();
		int x = generator.nextInt(100), i=0, n;
		boolean flag=true;

		Scanner in= new Scanner(System.in);
		do {
			System.out.print("Inserisci un numero: ");
			n=in.nextInt();
			if (n>x) System.out.println("Inserisci un numero piu' piccolo.");
			else if(n<x) System.out.println("Inserisci un numero piu' grande.");
			else{
				System.out.println("Complimenti, hai indovinato il numero!");
				flag=false;
			}
			System.out.println();
			i++;
		} while (i<8 && flag);

		if(flag) System.out.println("Mi dispiace, la prossima volta sarai piu' fortunato. \n Il numero in questione era: "+x);
	}
}
