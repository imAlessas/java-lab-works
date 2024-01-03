public class ArraySet implements Set{
    private Object[] v;
    private int vSize;
    public static final int INITIAL_SIZE = 10;

    public ArraySet(){
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

    @Override //O(n)
    public void add(Object obj) {
        if(!contains(obj))
            return;

        if(vSize == v.length)
            v = resize(v, v.length * 2);

        v[vSize++] = obj;
    }

    private Object[] resize(Object[] v, int newSize){
        if(newSize <= v.length)
            throw new IllegalArgumentException();

        Object[] newV = new Object[newSize];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override //O(n)
    public boolean contains(Object obj) {
        for(int i = 0; i < vSize; i++)
            if(obj.equals(v[i]))
                return true;
        return false;
    }

    @Override // O(n)
    public Object[] toArray() {
        Object[] copy = new Object[vSize];
        System.arraycopy(v, 0, copy, 0, vSize);
        return copy;
    }

    // non oridanto o(n^2)
    public static Set union(Set s1, Set s2){
        Set union = new ArraySet();

        Object[] temp = s1.toArray();
        for(int i = 0; i < temp.length; i++)
            union.add(temp[i]);
        temp = s2.toArray();
        for(int i = 0; i < temp.length; i++)
            union.add(temp[i]);
        
        return union;
    }

    // non oridanto o(n^2)
    public static Set intersection(Set s1, Set s2){
        Set intersection = new ArraySet();
        Object[] temp = s1.toArray();
        for(int i = 0; i < temp.length; i++)
            if(s2.contains(temp[i]))
                intersection.add(temp[i]);

        return intersection;
    }

    // non ordinato o(n^2)
    public static Set subtract(Set s1, Set s2){
        Set subtract = new ArraySet();
        Object[] temp = s1.toArray();
        for(int i = 0; i < temp.length; i++)
            if(!s2.contains(temp[i]))
                subtract.add(temp[i]);
        
        return subtract;
    }
}
