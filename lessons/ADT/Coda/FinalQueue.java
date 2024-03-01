public class FinalQueue implements Queue{
    private Object[] v;
    private int back, front;
    public static final int INITIAL_SIZE = 100;

    public FinalQueue(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        back = front = 0;
    }

    @Override
    public boolean isEmpty() {
        return back == front;
    }

    @Override
    public void enqueue(Object obj) {
        if(increment(back) == front)
            v = resize(2*v.length);
        
        if(back < front){
            System.arraycopy(v, 0, v, v.length/2, back);
            back += v.length/2;
        }
        
        v[back] = obj;
        back = increment(back);
    }

    protected int increment(int index){
        return (index + 1) % v.length;
    }

    protected Object[] resize(int size){
        if(size < v.length)
            throw new IllegalArgumentException();
        
        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override
    public Object getFront() {
        if(isEmpty())
            throw new EmptyQueueException();
        return v[front];
    }

    @Override
    public Object dequeue() {
        Object obj = getFront();
        front = increment(front);
        return obj;
    }



}
