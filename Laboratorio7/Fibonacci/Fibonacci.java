import java.util.Scanner;

public class Fibonacci {

    private static long iterativeFib(long n){
        if(n < 3)
            return 1;

        long n1 = 1;
        long n2 = 1;
        long fib = 0;
        for(long i = 2; i < n; i++){
            fib = n1 + n2;
            n1 = n2;
            n2 = fib;
        }

        return fib;
    }

    private static long recursiveFib(long n){
        if(n < 3)
            return 1;
        
        return recursiveFib(n-1) + recursiveFib(n-2);
    }


    public static void main(String[] args) {
        int num_fib;
        if(args.length == 1)
            num_fib = Integer.parseInt(args[0]);
        else{
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Fibonacci number: ");
            num_fib = keyboard.nextInt();
            keyboard.close();
        }

        long time1 = System.currentTimeMillis();
        System.out.println(iterativeFib(num_fib));
        long time2 = System.currentTimeMillis();
        System.out.println("Tempo impiegato: " + (time2 - time1)/1000 + " secondi.");
        

        time1 = System.currentTimeMillis();
        System.out.println(recursiveFib(num_fib));
        time2 = System.currentTimeMillis();
        System.out.println("Tempo impiegato: " + (time2 - time1)/1000 + " secondi.");
    }
}
