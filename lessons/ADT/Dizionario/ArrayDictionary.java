public class ArrayDictionary implements Dictionary{
    protected Pair[] v;
    protected int vSize;
    public static final int INITIAL_SIZE = 100;

    public ArrayDictionary(){
        v = new Pair[INITIAL_SIZE];
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
    public void insert(Comparable key, Object value) {
        if(key == null)
            throw new IllegalArgumentException();

        try{
            remove(key); // elimina l'elemento se già
        } catch (DictionaryItemNotFoundException x){}
        
        if(vSize == v.length)
            v = resize(2 * v.length);
        v[vSize++] = new Pair(key, value);
    }

    protected Pair[] resize(int size){
        if(size < v.length)
            throw new IllegalArgumentException();

        Pair[] newV = new Pair[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    @Override
    public void remove(Comparable key) {
        /* è --vSize e non vSize-- perche la variabile vSize punta alla prima cella libera e non all'ultima occupata
            se infatti ci fosse vSize-- v[...] savrebbe il valore di una cella inutilizzata e non il valore dlel'ultima cella
            utilizzata disponibile. */
        v[linearSearch(key)] = v[--vSize];
    }


    @Override
    public Object find(Comparable key) {
        return v[linearSearch(key)].getValue();
    }

    private int linearSearch(Comparable key){
        for(int i = 0; i < vSize; i++)
            if(key.compareTo(v[i].getKey()) == 0)
                return i;
        throw new DictionaryItemNotFoundException();
    }


    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < vSize; i++)
            s += v[i] + "\n";

        return s;
    }

    private void printCiao(){System.out.println("Ciao");}

    protected class Pair{
        private Comparable key;
        private Object value;

        public Pair(Comparable key, Object value){
            this.key = key;
            this.value = value;
        }

        public Comparable getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setKey(Comparable key) {
            this.key = key;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
    }
}
