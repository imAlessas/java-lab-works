public class FixedArrayStack implements Stack{
    // protected ai fini dell'esercizio, dovrebbero essere private
    protected Object[] v;
    protected int vSize;
    public static final int INITIAL_SIZE = 100;

    public FixedArrayStack(){
        v = new Object[INITIAL_SIZE];
        makeEmpty();
    }

    public boolean isEmpty(){ return vSize == 0; }

    public void makeEmpty(){ vSize = 0; }

    public void push(Object obj){
        if(vSize == v.length)
            throw new FullStackException(); // eccezione definita nell'interfaccia Stack
        //prima prendo vSize, poi la incremento
        v[vSize++] = obj;
    }

    public Object top(){
        if(isEmpty())
            throw new EmptyStackException();

        return v[vSize -  1];       
    }

    public Object pop(){
        Object top = top();
        vSize--;
        return top;
    }
}
