import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SortedContainerTester {
    public static void main(String[] args) {
        if(args.length != 2)
            System.exit(1);
        
        String sourceFile = args[0];
        String destFile = args[1];

        SortedContainer container = new SortedContainer();

        try {
            // Lettura nel file
            FileReader source = new FileReader(sourceFile);
            Scanner file = new Scanner(source);
            
            while(file.hasNextLine()){
                Scanner word = new Scanner(file.nextLine());
                word.useDelimiter(":");
                
                String nome = word.next();
                int matricola = Integer.parseInt(word.next());
                Student student = new Student(nome, matricola);
    
                container.add(student);
            }
    
            file.close();
            source.close();

            //Scrittura nel file
            PrintWriter destination = new PrintWriter(destFile);
            while(!container.isEmpty()){
                Student last = (Student)container.removeMax();
                destination.println(last);
            }
            destination.close();

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        } catch(IOException e){
            System.out.println(e);
        }
        
    }
}
