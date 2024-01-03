import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumberTester {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        boolean flag =true;

        do{
            try{

                System.out.print("Inserisci un numero intero positivo: ");
                int n = keyboard.nextInt();
                
                if(n!=1){
                    FactorGenerator g = new FactorGenerator(n);
                    if(g.nextFactor()==n)
                        System.err.println(n + " è un numero primo.");
                    else
                        System.err.println(n + " NON è un numero primo.");
                }else System.out.println(n + " è un numero primo.");


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
