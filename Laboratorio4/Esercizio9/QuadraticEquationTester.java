import java.util.concurrent.DelayQueue;

public class QuadraticEquationTester {
    public static void main(String[] args) {
        System.out.println();
        QuadraticEquation e1 = new QuadraticEquation(0, 4, 4);
        System.out.println(e1);
        if(e1.hasSolutions()){
            if(e1.nSolution() == 2 && e1.delta() > 0){
                System.out.println("x1 = "+e1.getSolution1());
                System.out.println("x2 = "+e1.getSolution2());
            }else if(e1.delta()==0 || e1.nSolution()==1){
                System.out.println("x1,2 = "+e1.getSolution1());
            }else if(e1.nSolution()==-1) System.out.println("Soluzioni infinite.");
        } else System.out.println("L'equazione non ha soluzioni.");
    }
}
