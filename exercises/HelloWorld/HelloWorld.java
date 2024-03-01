import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String s = keyboard.nextLine();

        keyboard.close();

        System.out.println(s);
    }
}
