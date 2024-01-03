public class ArrayAlgs{

    public static void remove(int[] v, int vSize, int index){
        v[index] = v[vSize - 1];
    }

    public static void removeSorted(int[] v, int vSize, int index){
        for (int i=index; i<vSize-1; i++)
            v[i] = v[i + 1];
    }

    public static int[] insert(int[] v, int vSize, int index, int value){
        if (vSize == v.length)
            v = resize(v, 2*v.length);
        for (int i = vSize; i > index; i--)
            v[i] = v[i - 1];
        v[index] = value;
        return v;
    }

     public static int linearSearch(int[] v, int vSize, int value){
        for (int i = 0; i < vSize; i++)
            if (v[i] == value) return i; // trovato valore
        return -1;  // valore non trovato
    }

    public static int findMin(int[] v, int vSize)
    {
        int min = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i] < min)
                min = v[i];
        return min;
    }

    public static int findMax(int[] v, int vSize){
        int max = v[0];
        for (int i = 1; i < vSize; i++)
            if (v[i] > max)
                max = v[i];
        return max;
    }

    // ----------------------- altri metodi di utilita` ---------------------

    // Ridimensiona l'array oldv attribuendogli la lunghezza newLength
    public static int[] resize(int[] oldv, int newLength){
        if (newLength < 0 || oldv == null)
            throw new IllegalArgumentException();
        int[] newv = new int[newLength];
        int count = oldv.length;
        if (newLength < count) 
            count = newLength;
        for (int i = 0; i < count; i++)
            newv[i] = oldv[i];
        return newv;
    }

    // Costruisce un array contenente valori casuali compresi tra 0 e n-1
    public static int[] randomIntArray(int length, int n){
        int[] v = new int[length];
        for (int i = 0; i < v.length; i++)
            // ricordiamoci come funziona Math.random()...
        v[i] = (int) (n * Math.random());
        return v;
    }

     //Stampa tutti gli elementi di un array.
    public static String printArray(int[] v, int vSize){
        String s = "[";
        for (int i = 0; i<vSize; i++)
            s = s + v[i] + " ";
        s = s + "\b]";
        return s;
    }
}