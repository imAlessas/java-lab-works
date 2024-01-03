import java.util.EmptyStackException;

public class StackByQueue implements Stack{
    //campi di esemplare
    private ArrayQueue q;

    public StackByQueue(){
        q = new ArrayQueue(); 
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }

    public void makeEmpty(){
        q.makeEmpty();
    }

    public void push(Object obj){
        ArrayQueue app = new ArrayQueue();
        while(!isEmpty())
            app.enqueue(q.dequeue());

        q.enqueue(obj);

        while(!app.isEmpty())
            q.enqueue(app.dequeue());
    }

    public Object top(){
        if(isEmpty())
            throw new EmptyStackException();
        return q.getFront();
    }

    public Object pop(){
        return q.dequeue();
    }
}
