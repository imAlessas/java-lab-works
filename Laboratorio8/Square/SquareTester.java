import java.util.Scanner;

public class SquareTester {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Inserisci la tripla del primo quadrato (x, y, lato): ");
        int x = Integer.parseInt(keyboard.next());
        int y = Integer.parseInt(keyboard.next());
        int side = Integer.parseInt(keyboard.next());
        Square q1 = new Square(x, y, side);

        System.out.print("Inserisci la tripla del secondo quadrato (x, y, lato): ");
        x = Integer.parseInt(keyboard.next());
        y = Integer.parseInt(keyboard.next());
        side = Integer.parseInt(keyboard.next());
        Square q2 = new Square(x, y, side);

        sortPrint(q1, q2);

      
        System.out.print("Inserisci la coppia per rideminsionare il primo quadrato (altezza, lunghezza): ");
        int width = Integer.parseInt(keyboard.next());
        int height = Integer.parseInt(keyboard.next());

        System.out.print("Inserisci la coppia per rideminsionare il primo quadrato (altezza, lunghezza): ");
        int width1 = Integer.parseInt(keyboard.next());
        int height1 = Integer.parseInt(keyboard.next());


        try {
            q1.setSize(width, height);
            q2.setSize(width1, height1);

            sortPrint(q1, q2);

        } catch (IllegalArgumentException e) {
            System.out.println("I valori inseriti non corrispondono ai valori necessari per un quadrato: " + e);
        }

        
        keyboard.close();
       
    }

    private static void sortPrint(Square q1, Square q2){
    if(q1.compareTo(q2) > 0)
        System.out.println(q1 + "\n" + q2);
    else
        System.out.println(q2 + "\n" + q1);
    }
}
