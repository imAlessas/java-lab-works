public class SlowFixedArrayQueue implements Queue{
    private Object[] v;
    private int vSize;
    public static final int INITIAL_SIZE = 100;
    
    public SlowFixedArrayQueue(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public boolean isEmpty() {
        return vSize == 0;
    }

    @Override
    public void makeEmpty() {
        vSize = 0;
    }

    @Override
    public void enqueue(Object obj) {
        if(vSize == v.length)
            throw new FullQueueException();
        
        v[vSize++] = obj;
    }

    @Override
    public Object getFront() {
        if(isEmpty())
            throw new EmptyQueueException();
        return v[0];
    }

    @Override
    public Object dequeue() {
        Object front = getFront();
        vSize--;
        for(int i = 0; i < vSize; i++)
            v[i] = v[i + 1];
        return front;
    }

    /*    tutti i metodi sono O(1) tranne dequeue che è sempre O(n)    */
}
