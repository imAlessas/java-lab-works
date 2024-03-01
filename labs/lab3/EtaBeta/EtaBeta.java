import java.util.Scanner;

public class EtaBeta{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci una frase del tipo 'Articolo Verbo Sostantivo Aggettivo': ");
		String s= in.nextLine().toLowerCase();
		s= s.substring(0,1).toUpperCase() + s.substring(1);

		System.out.println("Risultato: " + addP(s));
	}//main

	private static String addP(String s){
		String[] words = s.split(" ");
		return words[0] + " p"+ words[1]+" "+words[2]+" p"+words[3];
	}//addP

}//EtaBeta
