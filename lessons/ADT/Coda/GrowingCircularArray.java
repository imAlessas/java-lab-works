public class GrowingCircularArray extends FixedCircularArrayQueue{
    @Override
    public void enqueue(Object obj) {
        if(increment(back) == front)
            v = resize(v.length * 2);
        

        if(back < front){
            System.arraycopy(v, 0, v, v.length/2, back);
            back += v.length/2;
        }

        v[back] = obj;
        back = increment(back);
    }

    protected Object[] resize(int size){
        if(size < v.length)
            throw new IllegalArgumentException();

        Object[] newV = new Object[size];
        System.arraycopy(v, 0, newV, 0, v.length);

        return newV;
    }
}
