public class QuadraticEquation{

    private double a;
    private double b;
    private double c;

    //Costruttore: riceve i coefficienti a, b, c dell'equazione quadratica e inizializza i campi di esemplare secondo i valori ricevuti
    public QuadraticEquation(double acoeff, double bcoeff, double ccoeff){
        a=acoeff;
        b=bcoeff;
        c=ccoeff;
    }

    // calcola il delta dell'equazione
    public double delta(){
        return Math.pow(b, 2) -(4*a*c);
    }

    // Restituisce la prima delle due soluzioni dell'equazione quadratica, usando la ben nota formula...
    public double getSolution1(){
        if(nSolution()==1)  return -c/b;
        else return (-b-Math.sqrt(delta()))/(2*a);
    }


    // Restituisce la seconda delle due soluzioni dell'equazione quadratica, usando la ben nota formula...
    public double getSolution2(){
        return (-b+Math.sqrt(delta()))/(2*a);
    }



    //Restituisce il valore false se l'equazione non ha soluzioni(ovvero se il discriminante e` negativo)
    public boolean hasSolutions(){
        return delta()>=0;
    }

    // indica il numero di soluzione dell'equazione (-1 = infinite)
    public int nSolution(){
        if(a==0){
            if(b==0){
                if(c==0){
                    return -1;
                }
                return 0;
            }
            return 1;
        }
        return 2;
    }

    public String toString(){
        String s="";

        if(a!=0) s=a+"x^2 ";

        if(b>0 && a!=0) s+="+ "+b+"x ";
        if((b>0 && a==0) || b<0) s+=b+"x ";

        if(c>0 && b!=0) s+="+ "+c+" ";
        if((c>0 && a==0 && b==0) || c<0) s+=c+" ";

        return s+"= 0";
    }
}