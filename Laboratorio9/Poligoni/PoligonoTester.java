import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PoligonoTester {
    public static void main(String[] args) {
        if(args.length != 1)
            System.exit(1);

        try {
            FileReader source = new FileReader(args[0]);
            Scanner file = new Scanner(source);

            SortedContainer container = new SortedContainer();
            Poligono p;

            int a, b, c;

            while(file.hasNextLine()){
                Scanner line = new Scanner(file.nextLine());
                String s = line.next();
                if(s.equals("[T]")){
                    a = Integer.parseInt(line.next());
                    b = Integer.parseInt(line.next());
                    c = Integer.parseInt(line.next());

                    p = new Triangolo(a, b, c);
                } else if(s.equals("[R]")){
                    a = Integer.parseInt(line.next());
                    b = Integer.parseInt(line.next());

                    p = new Rettangolo(a, b);
                } else if(s.equals("[Q]")){
                    a = Integer.parseInt(line.next());

                    p= new Quadrato(a);
                } else p = null;

                container.add(p);

            }

            file.close();
            source.close();

            System.out.println("Poligoni in ordine di area: ");
            System.out.println(container);

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
