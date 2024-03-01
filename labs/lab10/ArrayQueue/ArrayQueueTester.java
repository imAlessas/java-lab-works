import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayQueueTester {
   public static void main(String[] args) {
    if(args.length != 1){
        System.err.println("Parametro in ingresso non valido.");
        System.exit(1);
    }

    Scanner read = new Scanner(System.in);
    ArrayQueue text = new ArrayQueue();

    while(read.hasNextLine())
        text.enqueue(read.nextLine());

    read.close();

    try {
        PrintWriter write = new PrintWriter(args[0]);
        while(!text.isEmpty())
            write.println(text.dequeue());

        write.close();
    } catch (FileNotFoundException e) {
        System.err.println("File not found.");
    }
   } 
}
