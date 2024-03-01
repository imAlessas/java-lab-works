public class RecSelectionSort {
    public static void main(String[] args) {
        if(args.length != 2)
            System.exit(1);

        int vSize = Integer.parseInt(args[0]);
        int maxNumber = Integer.parseInt(args[1]);

        int[] numbers = new int[vSize];

        for(int i = 0; i < vSize; i++)
        numbers[i] = (new java.util.Random()).nextInt(maxNumber) + 1;

        
        for(int value : numbers)
            System.out.println(value);

        System.out.println("----------------");
        selectionSort(numbers, vSize);

        for(int value : numbers)
            System.out.println(value);

    }

    public static void selectionSort(int[] v, int vSize){
        if(vSize == 0)
            return;

        int maxPos = findMaxPosition(v, 0, vSize);
        swap(v, maxPos, vSize - 1);

        selectionSort(v, vSize - 1);
    }

    private static int findMaxPosition(int[] v, int from, int size){
        int max = v[from], maxPos = from;

        for(int i = from + 1; i < size; i++){
            if(v[i] > max){
                max = v[i];
                maxPos = i;
            }
        }

        return maxPos;
    }

    private static void swap(int[] v, int pos1, int pos2){
        int temp = v[pos2];
        v[pos2] = v[pos1];
        v[pos1] = temp;
    }
}
