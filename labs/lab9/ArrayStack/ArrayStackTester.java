import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayStackTester {
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Parametro in ingresso non valido.");
            System.exit(1);
        }

        boolean sort = false;

        Scanner read = new Scanner(System.in);
        ArrayStack text = new ArrayStack();

        while(read.hasNextLine())
            text.push(read.nextLine());

        read.close();

        try {
            PrintWriter write = new PrintWriter(args[0]);
            while(!text.isEmpty())
                write.println(text.pop());
    
            write.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }

        if(sort){
            ArrayStack toSort = new ArrayStack();

            toSort.push("a");
            toSort.push("f");
            toSort.push("i");
            toSort.push("e");
            toSort.push("");
            toSort.push("z");
            toSort.push("s");
            toSort.push("w");
            toSort.push("b");
            toSort.push("+");
            toSort.push("|");
            toSort.push("c");
    
            ArrayStack.sortStack(toSort);
    
            while(!toSort.isEmpty())
                System.out.println(toSort.pop());
        }
    }
}
