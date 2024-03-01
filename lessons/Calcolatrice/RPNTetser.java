import java.util.Scanner;
import java.util.Stack;

public class RPNTetser {

    private static double getRPN(String rpnString) 
    throws  EmptyStackException, NumberFormatException,  IllegalStateException{
        Stack st = new GrowingArrayStack(); // devo fare questa classe
        Scanne linescan = new Scanner(rpnString);

        while(linescan.hasNext()){ //finche non è vuoto
            String symbol = linescan.next();
            if(isOperator(symbol)){ // controllo se il token è un operatore
                Double r = getOperation(symbol, (Double)st.pop(),(Double)st.pop());
                st.push(r);
            } else
                st.push(Double.parseDouble(symbol));
        }
        double result = st.pop();
        if(!st.isEmpty())
            throw new IllegalStateException();
        return result;
    }

    private static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static double getOperation(String s, double left, double right){
        if(s.equals("+"))
            return left + right;
        if(s.equals("-"))
            return left - right;
        if(s.equals("*"))
            return left * right;
        return left / right;
    }

    public static void main(String[] args) {
        System.out.println("Inserisci un'oprazione scritta in notazione polacca.");
        System.out.println("Sono accettati numeri e operatori separati da spazi.");

        Scanner keyboard = new Scanner(System.in);
        String rpnString = keyboard.nextLine();
        keyboard.close();

        /* Gestisco tutte le eccezioni che possono essere generate da getRPN() */
        try{
            System.out.println("Risultato :" + getRPN(rpnString));
        }catch(NumberFormatException e){ // se durante il pareseInt non va bne

        }
    }
}
