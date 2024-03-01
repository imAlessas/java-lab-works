public class BinarySearch{
    public static void main(String[] args) {
        final int SIZE = 1000; 
        int[] numbers = new int[SIZE];
        
        for(int i = 0; i < SIZE;  i++)
            numbers[i] = (new java.util.Random()).nextInt(1000);

        // è necessario che l'array sia ordinato prima di fare la binarySearch
        MergeSort.mergeSort(numbers, numbers.length);


        // for(int value : numbers)
            // System.out.println(value);

        int pos = binarySearch(numbers, numbers.length, 120);
        if(pos > 0)
            System.out.println("Posizione " + pos + ": " + numbers[pos]);
        else
            System.out.println("Value non found");
    }

    public static int binarySearch(int[] v, int vSize, int value){
        // a volte è necessario un metodo ausiliario per fare partire la ricorsione
        return binSearch(v, 0, vSize - 1, value);
    }

    private static int binSearch(int[] v, int from, int to, int value){
        // caso base
        if(from > to)
            return -1;

        int mid = (from + to) / 2;
        int midValue = v[mid];

        // se ho trovato il valore
        if(midValue == value)
            return mid;

        if(midValue > value)
            return binSearch(v, from, mid - 1, value); // se value è più grande devo guardare sulla prima metà dell'array (che va da from a mid - 1)
        // else
        return binSearch(v, mid + 1, to, value); // altrimenti si trova nella seconda metà
    }
}