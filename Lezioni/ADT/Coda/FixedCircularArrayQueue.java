public class FixedCircularArrayQueue extends FixedArrayQueue{
    /* Questo è il metodo più importante: garantisce la circolarità dell'array */
    protected int increment(int index){
        return (index + 1) % v.length;
    }

    @Override
    public void enqueue(Object obj) {
        if(increment(back) == front)
            throw new FullQueueException();
        v[back] = obj;
        back = increment(back);
    }

    @Override
    public Object dequeue() {
        Object obj = getFront();
        front = increment(front);
        return obj;
    }

}
