import java.awt.Rectangle;

public class Square extends Rectangle implements Comparable{
    // varaibili di esemplare
    // heigth, width
    // x, y

    /** Costruttore parametrico */
    public Square(int x, int y, int side){
        super();
        setLocation(x-side/2, y-side/2);
        setSize(side);
    }

    /** getArea()
     * @return the area of the square
     */
    public int getArea(){
        return (int)Math.pow(height,2);
    }

    @Override
    public void setSize(int width, int height){
        if(width == height)
            this.width = this.height = width;
        else
            throw new IllegalArgumentException();
    }
    
    
    public void setSize(int side){
        height = width = side;
    }
    
    public int compareTo(Object obj){
        Square q = (Square)obj;
        if(this.getArea() > q.getArea())   
            return 1;
        else if(this.getArea() < q.getArea())
            return -1;
        return 0;
    }
}