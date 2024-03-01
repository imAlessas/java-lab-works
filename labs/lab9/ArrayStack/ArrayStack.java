public class ArrayStack implements Stack{
    private Object[] v;
    private int vSize;
    public static final int INITIAL_SIZE = 10;

    public ArrayStack(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    @Override
    public void makeEmpty() {
        vSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return vSize == 0;
    }

    @Override
    public void push(Object obj) {
        if(vSize == v.length)
            v = resize(v, 2*v.length);
        
        v[vSize++] = obj;
    }

    private Object[] resize(Object[] v, int newSize){
        if(newSize < v.length)
            throw new IllegalArgumentException();
        
        Object[] newV = new Object[newSize];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override
    public Object top() {
        if(isEmpty())
            throw new EmptyStackException();
        
        return v[vSize - 1];
    }

    @Override
    public Object pop() {
        Object obj = top();
        vSize--;
        return obj;
    }

    public static void sortStack(ArrayStack v){
        ArrayStack sorted = new ArrayStack();

        while(!v.isEmpty()){
            ArrayStack a = new ArrayStack();
            
            Comparable min = (Comparable)v.top();

            // trovo il valore minimo
            while(!v.isEmpty()){
                if(min.compareTo((Comparable)v.top()) > 0)
                    min = (Comparable)v.top();
                // salvo la pila su a
                a.push(v.pop());
            }

            // trasferisco tutto su v
            while(!a.isEmpty()){
                if(min.compareTo((Comparable)a.top()) != 0)
                    v.push(a.pop());
                else
                    a.pop();
            }

            // inserisco min nella pila
            sorted.push(min);
        }

        while(!sorted.isEmpty())
            v.push(sorted.pop());
        
    }
}
