import java.io.IOException;
import java.io.PrintWriter;

public class StudentContainerTester {
    public static void main(String[] args) {
        if(args.length != 2)
            System.exit(1);

        
        try {
            StudentContainer container = new StudentContainer(args[0]);

            PrintWriter destination = new PrintWriter(args[1]);
            while(!container.isEmpty()){
                Student last = (Student)container.removeMax();
                destination.println(last);
            }
            destination.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
