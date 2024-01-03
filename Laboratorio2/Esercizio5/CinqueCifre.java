import java.util.Scanner;

public class CinqueCifre{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s;
		int num;
		boolean isInt = true, isNeg=false;

		do {
			isInt=true;
			isNeg=false;
			System.out.print("Inserisci un numero: ");
			s=in.nextLine();
			try {
				num = Integer.parseInt(s);
				isNeg=num<0;
			} catch(Exception e) {
				isInt=false;
			}
		} while (s.length()>5 || !isInt || isNeg);

		for (int i=0; i<s.length(); i++) {
			System.out.print(s.charAt(i)+" ");
		}
	}//main
}//CinqueCifre
