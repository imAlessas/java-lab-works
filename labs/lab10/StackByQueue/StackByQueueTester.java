public class StackByQueueTester{
    public static void main(String[] args) {
        ArrayStack pila = new ArrayStack();
        StackByQueue pilaCoda = new StackByQueue();

        pila.push("bene.");
        pilaCoda.push("bene.");

        pila.push("sto");
        pilaCoda.push("sto");

        pila.push("Io");
        pilaCoda.push("Io");

        pila.push("stai?");
        pilaCoda.push("stai?");

        pila.push("come");
        pilaCoda.push("come");

        pila.push("Ciao");
        pilaCoda.push("Ciao");

        System.out.println("----- Pila ------");
        while(!pila.isEmpty())
            System.out.println(pila.pop());


        System.out.println("----- PilaCoda ------");
        while(!pilaCoda.isEmpty())
            System.out.println(pilaCoda.pop());
    }
}