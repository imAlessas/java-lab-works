import java.lang.Thread;
import java.util.Scanner;

public class ListaParole extends Thread{

	private static void fancyWord(){
		Scanner input=new Scanner(System.in);

		//get the word
		System.out.print("Scrivi qualcosa: ");
		String word=input.nextLine();

		// get the reps
		System.out.print("Inserisci un unmero: ");
		int reps= input.nextInt();

		//get the time and the calculate the seconds between a rep and another one
		System.out.print("In quanti secondi vuoi visualizzare le parole? ");
		int secs= (input.nextInt())*1000/reps;

		// print the word*reps
		for (int i=0; i<reps; i++) {
			// build the index
			// --> convert var reps into a string so it can get the length of the String
			// --> the length is going to be inside tge string: "%0-length-d"
			// -->with the String.format method create the index string with the right amount of digits
			String index = String.format("%0"+(reps+"").length()+"d", (i+1));

			System.out.println(index + ". "+word.toUpperCase());
			try {
				Thread.sleep(secs);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}

	}

	public static void main(String[] args) {
		fancyWord();
	}
}
