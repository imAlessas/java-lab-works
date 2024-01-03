public class ArrayQueue implements Queue{
    private Object[] v;
    private int front, back;
    public static final int INITIAL_SIZE = 10;
    
    public ArrayQueue(){
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

    private int increment(int index){
        return (index + 1) % v.length;
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

    @Override
    public void enqueue(Object obj) {
        if(increment(back) == front)
            v = resize(v, v.length*2);

        if(back < front){
            System.arraycopy(v, 0, v, v.length / 2, back);
            back += v.length/2;
        }

        v[back] = obj;
        back = increment(back);
        
    }

    protected static Object[] resize(Object[] v, int size){
        if(size < v.length)
            throw new IllegalArgumentException();

        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }
    
}
