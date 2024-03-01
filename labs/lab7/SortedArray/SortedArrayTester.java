import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class SortedArrayTester {
    public static void main(String[] args) {
        if(args.length == 2){
            int n = Integer.parseInt(args[0]);
            String fileName = args[1];

            // inserimento dei dati
            Random generator = new Random();
            SortedArray numbers = new SortedArray();

            for(int i = 0; i < n; i++)
                numbers.add(generator.nextInt(n) + 1);
                

            // media
            System.out.println("Il valore della media degli elemnti e': " + numbers.avg());

            // ricerca valore
            Scanner keyboard = new Scanner(System.in);

            String choice = "";
            boolean done = false;
            int value = 0;

            
            do {
                System.out.print("Inserisci il numero che vuoi cercare. Premere 'Q' se si vuole uscire.\n--> ");
                choice = keyboard.next().toUpperCase();
                
                if(choice.charAt(0) == 'Q')
                    done = true;
                else{
                    value = Integer.parseInt(choice);
                    int pos = numbers.search(value);
                    if(pos == -1)
                        System.out.println("Il valore NON e' presente");
                    else
                        System.out.println("Il valore e' presente (posizione " + pos + ").");
                }
                
            } while (!done);
    
            keyboard.close();

            // Salvo l'array in un file di testo
            try {
                PrintWriter file = new PrintWriter(fileName);
                String s = "";
                int i = 0;
                int length = ("" + n).length();
                
                while(!numbers.isEmpty()){
                    s += String.format("%" + length + "d", numbers.removeMax()) + " ";
                    
                    i++;
                    if(i % 10 == 0)
                        s += "\n";

                }
                
                file.print(s);
                file.close();
            } catch (FileNotFoundException e) {
                System.out.println("File " + fileName + " non trovato.");
            }

        }
        else
            System.out.println("Inserimento dei parametri errato.");
    }
}
