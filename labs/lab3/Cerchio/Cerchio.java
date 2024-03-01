import java.util.Scanner;

public class Cerchio{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci il raggio di un cerchio: ");
		double r= in.nextDouble();

		System.out.println("Circonferenza: "+circonferenza(r));
		System.out.println("Area: "+area(r));
	}//main

	private static double circonferenza(double r){
		return 2*r*Math.PI;
	}//circonferenza

	private static double area(double r){
		return Math.PI*Math.pow(r,2);
	}//area
}//Cerchiio
