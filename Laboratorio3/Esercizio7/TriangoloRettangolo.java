import java.util.Scanner;

public class TriangoloRettangolo{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci il valore del primo cateto: ");
		double base = in.nextDouble();

		System.out.print("Inserisci il valore del secondo cateto: ");
		double altezza = in.nextDouble();

		System.out.printf("Ipotenusa: %1.2f cm\n",ipotenusa(base, altezza));
		System.out.printf("Perimetro: %1.2f cm\n",perimetro(base, altezza));
		System.out.printf("Area: %1.2f cm2\n",area(base, altezza));
		System.out.printf("Angolo 1: %1.2f °\n",angolo(base, ipotenusa(base, altezza)));
		System.out.printf("Angolo 2: %1.2f °\n",angolo(altezza, ipotenusa(base, altezza)));

	}//main

	private static double ipotenusa(double c1, double c2){
		return Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
	}//ipotenusa

	private static double perimetro(double c1, double c2){
		return c1+c2+ipotenusa(c1, c2);
	}//periemtro

	private static double area(double c1, double c2){
		return c1*c2/2;
	}//area

	private static double angolo(double c, double i){
		return Math.toDegrees(Math.asin(c/i));
	}//angolo

}//Triangolo
