import java.util.InputMismatchException;
import java.util.Scanner;

public class FactorGeneratorTester{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        boolean flag =true;

        do{
            try{

                System.out.print("Inserisci un numero intero positivo: ");
                int n = keyboard.nextInt();

                FactorGenerator g = new FactorGenerator(n);

                System.out.print("Elenco dei fattori primi di " + n + ": ");
                while(g.hasNextFactor())
                    System.out.print(g.nextFactor()+" ");

                flag = true;
            }catch(InputMismatchException x){
                System.out.println("E' stato richiesto un numero!");
                flag = false;
                keyboard.next();
            }catch(IllegalArgumentException x){
                System.out.println("Numero non valido!");
                flag = false;
            }
        }while(!flag);

        keyboard.close();
        
    }
}