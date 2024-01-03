import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class TextTester {
    public static void main(String[] args) {
        String fileName = "";
        if(args.length == 1)
            fileName = args[0];
        else
            System.exit(1);

        Text container = new Text();

        try{
            Pattern p = Pattern.compile("[\\p{javaWhitespace}\\p{Punct}]+");
            FileReader source = new FileReader(fileName);
            Scanner reader = new Scanner(source);

            while(reader.hasNext()){
                Scanner word = new Scanner(reader.nextLine());
                word.useDelimiter(p);
                while(word.hasNext())
                    container.insert(word.next());
            }

            reader.close();
            source.close();
        }catch(FileNotFoundException x){
            System.out.println("File inserito non esistente.");
            System.out.println(x);
        }catch(IOException x){
            System.out.println(x);
        }

        container.sort();
        System.err.println("----------\nArray ordinato\n");
        System.out.println(container);

        
        Text noDoubles = deleteDoubles(container);
        System.err.println("----------\nArray senza duplicati\n");
        System.out.println(noDoubles);
    }

    private static Text deleteDoubles(Text c){
        c.sort();

        Text container = new Text();
        container.insert(c.get(0));

        for(int i = 1; i < c.size(); i++)
            if(!c.get(i).equals(container.get(container.size()-1)))
                container.insert(c.get(i));
        return container;
    }
}
