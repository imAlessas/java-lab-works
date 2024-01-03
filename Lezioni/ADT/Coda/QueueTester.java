import java.util.Random;

public class QueueTester{
    public static void main(String[] args){
        GrowingCircularArray coda = new GrowingCircularArray();
        Random generator = new Random();

        for(int i = 0; i < 200; i++){
            String s = "" + generator.nextInt(1000);
            System.out.println(s);
            coda.enqueue(s);
        }

        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("--------------------");

        for(int i = 0; i < 100; i++)
            System.out.println(coda.dequeue());

        for(int i = 0; i < 200; i++)
            coda.enqueue("Papere");

        

        while(!coda.isEmpty())
            System.out.println(coda.dequeue());
    }
}