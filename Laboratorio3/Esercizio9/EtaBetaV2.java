import java.util.Scanner;

public class EtaBetaV2{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Inserisci una frase del tipo 'Articolo Verbo Sostantivo Aggettivo': ");
		// utilizzare next() al posto di nextLine()
		String art= in.next().toLowerCase();
		String ver= in.next().toLowerCase();
		String sost= in.next().toLowerCase();
		String agg= in.next().toLowerCase();

		art= art.substring(0,1).toUpperCase() + art.substring(1);

		System.out.println(art+" p"+ver+" " +sost+" p"+agg+".");

	}//main

}//EtaBeta
