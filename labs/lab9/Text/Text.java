public class Text implements Container{
    private String[] v;
    private int vSize;
    private static final int INITIAL_SIZE = 100;

    // Void Builder
    public Text(){
        vSize = 0;
        v = new String[INITIAL_SIZE];
    }

    public boolean isEmpty(){
        return vSize == 0; 
    }

    public void makeEmpty(){
        vSize = 0;
    }

    public int size(){
        return vSize;
    }

    public String get(int index){
        return v[index];
    }

    // method whic insert a new text into the container
    public void insert(String s){
        if(v.length == vSize)
            resize();

        v[vSize] = s;
        vSize++;
    }

    // double the length of the array
    private void resize(){
        String[] newV = new String[v.length * 2];
        System.arraycopy(v, 0, newV, 0, v.length);
        v = newV;
    }

    public void sort(){
        mergeSort(v, vSize);
    }
    
    // mergeSort
    private void mergeSort(String[] v, int vSize){
        if(vSize < 2)
            return; //caso base
        
        int mid = vSize/2;
        String[] left = new String[mid];
        String[] right = new String[vSize - mid];

        System.arraycopy(v, 0, left, 0, mid); //copio la prima parte dell'array in left
        System.arraycopy(v, mid, right, 0, vSize - mid); //copio l'altra in right

        mergeSort(left, mid);
        mergeSort(right, vSize - mid);      

        merge(v, left, right);

    }

    private static void merge(String[] v, String[] v1, String[] v2){
        int i = 0, i1 =  0, i2 = 0;

        while(i1 < v1.length && i2 < v2.length)
            if(v1[i1].compareTo(v2[i2])  < 0)
                v[i++] = v1[i1++];
            else
                v[i++] = v2[i2++];

        while (i1 < v1.length)
            v[i++] = v1[i1++];
        while (i2 < v2.length)
            v[i++] = v2[i2++];
        
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < vSize; i++)
            s += v[i] + "\n";
        
        return s;
    }
}
