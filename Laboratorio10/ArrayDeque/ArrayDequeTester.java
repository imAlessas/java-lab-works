import java.util.Scanner;

public class ArrayDequeTester {
    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque();
        Scanner keyboard = new Scanner(System.in);

        boolean done = false;
        String choice = "";
        while(!done){
            System.out.print("Your choice: ");
            choice = keyboard.next().toUpperCase();
            Integer i;
            switch (choice) {
                case "Q":
                    done = true;
                    break;
                case "AF":
                    i = new Integer(keyboard.next());
                    deque.addFirst(i);
                    break;

                case "AL":                    
                    i = new Integer(keyboard.next());
                    deque.addLast(i);
                    break;

                case "RF":
                    deque.removeFirst();
                    break;

                case "RL":
                    deque.removeLast();
                    break;

                case "GF":
                    System.out.println(deque.getFirst());
                    break;

                case "GL":
                    System.out.println(deque.getLast());
                    break;
            
                default:
                    System.err.println("Invalid input.");
                    break;
            }
            System.out.println(deque);
            System.out.println("Size: " + deque.size());
            keyboard.nextLine();
        }

        keyboard.close();
    }
}
