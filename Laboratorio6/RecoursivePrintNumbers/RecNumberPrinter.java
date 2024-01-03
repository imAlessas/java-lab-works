public class RecNumberPrinter {

    private static String listNumbers(int n){
        if(n == 0)
            return "";

        return listNumbers(n-1) + n + " ";
    }

    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        System.out.println(listNumbers(number));
    }
}
