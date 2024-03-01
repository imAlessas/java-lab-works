import java.util.Scanner;
public class NumeroPrimo{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		int num= in.nextInt();
		int i=2, div=0;

		while(i<num && div==0){
			if((num%i)==0){
				div=i;
			}
			i++;
		}

		if(div==0) System.out.println("Il numero e' primo.");
		else System.out.println("Il divisore piu' piccolo del numero e': "+div);

		in.close();
	}
}
