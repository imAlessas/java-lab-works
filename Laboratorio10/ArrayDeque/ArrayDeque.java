public class ArrayDeque implements Deque{
    private Object[] v;
    private int front, back;
    public static final int INITIAL_SIZE = 2;

    public ArrayDeque(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        front = back = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == back;
    }

    @Override
    public int size() {
        if(isEmpty())
            return 0;
        
        if(front < back)
            return back - front;
        else
            return (v.length - front) + back;
    }

    private int increment(int index){
        return (index + 1) % v.length;
    }

    private int decrement(int index){
        return (index - 1 + v.length) % v.length;
    }

    private Object[] resize(Object[] v, int size){
        if(size < v.length)
            throw new IllegalArgumentException();
        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override
    public void addFirst(Object obj) {
        if(decrement(front) == back){
            v = resize(v, v.length * 2);
            if(back <= front){
                System.arraycopy(v, 0, v, v.length/2, back);
                back += v.length/2;
            }
        }

        front = decrement(front); // vado sulla cella libera prima
        v[front] = obj;
    }

    @Override
    public void addLast(Object obj) {
        if(increment(back) == front){
            v = resize(v, v.length * 2);
            if(back <= front){
                System.arraycopy(v, 0, v, v.length/2, back);
                back += v.length/2;
            }
        }

        v[back] = obj;
        back = increment(back);
    }

    @Override
    public Object getFirst() {
        if(isEmpty())
            throw new EmptyDequeException();
        
        return v[front];
    }

    @Override
    public Object getLast() {
        if(isEmpty())
            throw new EmptyDequeException();
        
        return v[back - 1];
    }

    @Override
    public Object removeFirst() {
        Object obj = getFirst();
        front = increment(front);
        return obj;
    }

    @Override
    public Object removeLast() {
        Object obj = getLast();
        back = decrement(back);
        return obj;
    }

    @Override
    public String toString() {
        String s = "[ " + v[front];;
        if(isEmpty())
            s += "";
        else if(front > back){
            // da front a v.length
            for(int i = front + 1; i < v.length; i++)
                s+= ", " + v[i];
            // da 0 a back
            for(int i = 0; i < back; i++)
                s+= ", " + v[i];
        }else
            for(int i = front + 1; i < back; i++)
                s += ", " + v[i] ;
        
        return s + " ]";
        
    }



}
