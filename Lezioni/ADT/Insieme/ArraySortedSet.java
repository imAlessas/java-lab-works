public class ArraySortedSet implements SortedSet{
    private Comparable[] v;
    private int vSize;
    private static final int INITIAL_SIZE = 10;

    public ArraySortedSet(){
        v = new Comparable[INITIAL_SIZE];
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

    @Override // o(n)
    public void add(Comparable obj) {
        if(contains(obj))
            return;
        if(vSize == v.length)
            v = resize(v, v.length * 2);
        
        v[vSize++] = obj;
        insertionSort(v, vSize); 
    }

    private void insertionSort(Comparable[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            Comparable temp = v[i];

            int j;
            for(j = i; j > 0 && temp.compareTo(v[j - 1]) < 0; j--)
                v[j] = v[j - 1];
            v[j] = temp;
        }
    }

    private Comparable[] resize(Comparable[] v, int newSize){
        if(newSize <= v.length)
            throw new IllegalArgumentException();

        Comparable[] newV = new Comparable[newSize];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override
    public void add(Object obj) {
        throw new IllegalArgumentException();
    }

    @Override // o(log(n))
    public boolean contains(Object obj) {
        return binarySearch(v, 0, vSize, obj) != -1;
    }

    private int binarySearch(Comparable[] v, int from, int to, Object value){
        if(from > to)
            return -1;
            
        int mid = (from + to) / 2;
        Comparable midValue = v[mid];

        if(midValue.compareTo(value) == 0)
            return mid;
        if(midValue.compareTo(value) > 0)
            return binarySearch(v, from, mid - 1, value);
        return binarySearch(v, mid + 1, to, value);
    }


    @Override // o(n)
    public Comparable[] toSortedArray() {
        Comparable[] copy = new Comparable[vSize];
        System.arraycopy(v, 0, copy, 0, vSize);
        return copy;
    }

    @Override
    public Object[] toArray() {
        return toSortedArray();
    }

   
    // o(nlog(n))
    public static SortedSet union(SortedSet s1, SortedSet s2){
        SortedSet union = new ArraySortedSet();
        Comparable[] v1 = s1.toSortedArray();
        Comparable[] v2 = s2.toSortedArray();

        int i1 = 0,  i2 = 0;

        while(i1 < v1.length && i2 < v2.length)
            if(v1[i1].compareTo(v2[i2]) <= 0)
                union.add(v1[i1++]);
            else
                union.add(v2[i2++]);
        
        while(i1 < v1.length)
            union.add(v1[i1++]);
        
        while(i2 < v2.length)
            union.add(v2[i2++]);

        return union;
    }

    // anche intersection e subtraction hanno O(nLog(n))


}
