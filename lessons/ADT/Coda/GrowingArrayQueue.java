public class GrowingArrayQueue extends FixedArrayQueue{
    // utlizzo il resize
    @Override
    public void enqueue(Object obj) {
        if(back == v.length)
            v = resize(v.length * 2);

        v[back++] = obj;
    }

    protected Object[] resize(int size){
        if(v.length > size)
            throw new IllegalArgumentException();

        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }
}
