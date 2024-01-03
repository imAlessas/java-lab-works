public class Quadrato implements Poligono{
    private int l;

    public Quadrato(int l){
        this.l = l;
    }

    public int perimetro(){
        return l * 4;
    }

    public double area(){
        return Math.sqrt(l);
    }

    public int compareTo(Object o){
        if(o instanceof Poligono){
            Poligono q = (Poligono)o;

            if(this.area() > q.area())
                return 1;
            if(this.area() < q.area())
                return -1;

            return 0;

        } else
            throw new IllegalArgumentException();
    }

    public String toString(){
        return "[Q] " + l;
    }

}
