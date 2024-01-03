public class GrowingArrayStack extends FixedArrayStack{
    // questa volta non lancio l'eccezione, ma faccio il resizing
    public void push(Object obj){
        if(vSize == v.length)
            v = resize(v.length * 2);
        
        v[vSize++] = obj;
    }

    // solo le sottoclassi possono invocare questo metodo
    protected Object[] resize(int size){
        if(size < v.length)
            throw new IllegalArgumentException();
        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);

        return newV;
    }
}
