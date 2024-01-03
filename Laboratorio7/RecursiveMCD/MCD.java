public class MCD{

    public static int recursiveMCD(int m, int n){
        if(m % n == 0)
            return n;
        
        return recursiveMCD(n, m % n);
    }

    public static void main(String[] args) {
        if(args.length == 2){
            int m = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);

            if(n*m > 0)
                System.out.println("MCD between " + Math.max(m,n) + " and " + Math.min(m, n) + " is: " +recursiveMCD(Math.max(m, n), Math.min(m,n)));
            else
                System.out.println("Invalid input");
        } else System.out.println("Too many paraeters.");
    }
}

