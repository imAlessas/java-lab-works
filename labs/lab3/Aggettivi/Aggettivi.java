import java.util.Scanner;

public class Aggettivi{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci un aggettivo: ");
		String agg = in.nextLine().toLowerCase();
		String dim, abs;

		if(isMasc(agg)){
			dim = agg.substring(0, agg.length()-1) + "ino";
			abs = agg.substring(0, agg.length()-1) + "issimo";
		}else{
			dim = agg.substring(0, agg.length()-1) + "ina";
			abs = agg.substring(0, agg.length()-1) + "issima";
		}
		System.out.println();
		showAgg(captionLetter(agg), captionLetter(dim), captionLetter(abs));
	}//main

	private static boolean isMasc(String s){
		if(Character.valueOf(s.charAt(s.length() - 1)).compareTo(Character.valueOf('o'))==0){
			return true;
		}else return false;
	}//isMasc

	private static String captionLetter(String s){
		return s.substring(0,1).toUpperCase() + s.substring(1, s.length());
	}//captionLetter

	private static void showAgg(String s1, String s2, String s3){
		System.out.println("Aggettivo inserito: " +s1);
		System.out.println("Forma diminutiva: "+s2);
		System.out.println("Superlativo assoluto: "+s3);
	}//showAgg

}//Aggettivi
