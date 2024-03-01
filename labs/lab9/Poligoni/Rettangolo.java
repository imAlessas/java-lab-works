public class Rettangolo implements Poligono{
    private int base;
    private int altezza;

    public Rettangolo(int base, int altezza){
        this.base = base;
        this.altezza = altezza;
    }
    
    public int perimetro(){
        return (base + altezza) * 2;
    }

    public double area(){
        return base * altezza;
    }

    public int compareTo(Object o){
        if(o instanceof Poligono){
            Poligono r = (Poligono)o;

            if(this.area() > r.area())
                return 1;
            if(this.area() < r.area())
                return -1;

            return 0;

        } else
            throw new IllegalArgumentException();
    }

    public String toString() {
        return "[R] " + base + " " + altezza;
    }
}
