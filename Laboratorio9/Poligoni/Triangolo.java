public class Triangolo implements Poligono {
    private int a;
    private int b;
    private int c;

    public Triangolo(int l1, int l2, int l3){
        if(!isTriangolo(l1, l2, l3))
            throw new IllegalArgumentException();
        
        a = Math.min(Math.min(l1, l2), Math.min(l2, l3));
        c = Math.min(Math.max(l1, l2), Math.max(l2, l3));
        
        int s = l1 + l2 + l3;
        b = s - (a + c);
    }

    private boolean isTriangolo(int a, int b, int c){
        if( a < (b + c) && a > (Math.abs(b - c)) &&
            b < (a + c) && b > (Math.abs(a - c)) &&
            c < (a + b) && c > (Math.abs(a - b)))
            return true;
            return false;
    }

    
    /*  0 se acutangolo
        1 se rettangolo
        2 se ottusangolo 
        
        OBSOLETO
        */
    private int tipoTriangolo(){
        if( a*a < (b*b + c*c) &&
            b*b < (a*a + c*c) &&
            c*c < (a*a + b*b ))
            return 0;
        
        if( a*a > (b*b + c*c) &&
            b*b > (a*a + c*c) &&
            c*c > (a*a + b*b ))
            return 2;
        
        return 1;
        
    }

    public int perimetro(){
        return a + b + c;
    }

    // formula di Erone
    public double area(){
        double p = perimetro() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));        
    }

    public int compareTo(Object o){
        if(o instanceof Poligono){
            Poligono t = (Poligono)o;

            if(this.area() < t.area())
                return -1;
            if(this.area() > t.area())
                return 1;
            
            return 0;

        } else
            throw new IllegalArgumentException();
    }

    public String toString(){
        return "[T] " + a + " " + b + " " + c;
    }

}
