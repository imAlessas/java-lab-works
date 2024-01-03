import java.util.Scanner;

public class Gradi{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci un angolo (in gradi): ");
		double gradi= in.nextDouble()%360;
		double rad= Math.toRadians(gradi);

		System.out.println("Valore in gradi: "+gradi);
		System.out.printf("Valore in radianti: %1.3f * \u03C0 \n",(rad/Math.PI));
		System.out.printf("Seno: %1.3f \n",Math.sin(rad));
		System.out.printf("Coseno: %1.3f \n",Math.cos(rad));
		System.out.printf("Tangente: %1.3f \n",Math.tan(rad));
	}
}
