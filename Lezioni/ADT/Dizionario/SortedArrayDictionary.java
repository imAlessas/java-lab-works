public class SortedArrayDictionary extends ArrayDictionary{
    @Override
    public void insert(Comparable key, Object value) {
        if(key == null)
            throw new IllegalArgumentException();
        // se c'è rimuove il valore
        try{ remove(key); }
        catch(DictionaryItemNotFoundException x){}

        if(vSize == v.length)
            v = resize(v.length * 2);
        
        v[vSize++] = new Pair(key, value);
        insertionSort(v, vSize);
    }

    @Override
    public void remove(Comparable key) {
        int index = binarySearch(v, vSize, key);
        vSize--;
        for(int i = index; i < vSize; i++)
            v[i] = v[i + 1];
    }

    @Override
    public Object find(Comparable key) {
        return v[binarySearch(v, vSize, key)].getValue();
    }

    private int binarySearch(Object[] v, int vSize, Comparable key){
        return binSearch(v, 0, v.length, key);
    }

    private int binSearch(Object[] v, int from, int to, Comparable key){
        if(from > to)
            return -1;
        
        int mid = (from + to) / 2;
        Object midValue = v[mid];

        if(key.compareTo(midValue) == 0)
            return mid;

        if(key.compareTo(midValue) > 0)
            return binSearch(v, mid + 1, to, key);
        
        return binSearch(v, from, mid - 1, key);    
    }

    private void insertionSort(Object[] v, int vSize){
        for(int i = 0; i < vSize; i++){
            Object temp = v[i];
            
            int j;
            for(j = i; j > 0 && ((Comparable) v[j - 1]).compareTo(temp) > 0; j--)
                v[j] = v[j - 1];

            v[j] = temp;
        }
    }

}
