public class FixedArrayQueue implements Queue{
    protected Object[] v;
    protected int front, back;
    public static final int INITIAL_SIZE = 100;

    public FixedArrayQueue(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public boolean isEmpty() {
        return front == back;
    }

    @Override
    public void makeEmpty() {
        front = back = 0;
    }

    @Override
    public Object getFront() {
        if(isEmpty())
            throw new EmptyQueueException();
        return v[front];
    }

    @Override
    public Object dequeue() {
        Object temp = getFront();
        front++;
        return temp;
    }

    @Override
    public void enqueue(Object obj) {
        if(back == v.length)
            throw new FullQueueException();
        v[back++] = obj;
    }

}
