import java.util.Scanner;

public class Orari{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m;

		do {
			System.out.print("Inserisci il primo orario: ");
			n = in.nextInt();
		} while (String.valueOf(n).length() > 4);

		do {
			System.out.print("Inserisci il secondo orario: ");
			m = in.nextInt();
		} while (String.valueOf(m).length() > 4);

		String s = String.format("%4d", (Math.abs(n-m)));
		System.out.println(s);
		System.out.println("Tempo trascorso: " + s.substring(0, 2) + " ore e "+s.substring(2,4)+" minuti.");

		System.out.println( ("CIAO").substring(0,("CIAO").length()));
	}//main
}//Orari
