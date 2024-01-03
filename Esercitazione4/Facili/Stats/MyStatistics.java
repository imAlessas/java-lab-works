import java.util.Scanner;

public class MyStatistics {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        final int INITIAL_SIZE = 200;
        int[] data = new int[INITIAL_SIZE];

        
        int i = 0;
        while(keyboard.hasNextInt()){
            data[i] = keyboard.nextInt();
            i++;
        }
        
        keyboard.close();

        double media = somma(data, i)/i;
        System.out.println("Media: " + media);

        int temp = 0;
        for(int j = 0; j < i; j++)
            temp += Math.pow((data[j] - media), 2);
        
        double stnrDev = Math.sqrt(temp / i);
        System.out.println("Deviazione standard: " + stnrDev);

        System.out.println("----- Prof -----");

        solProf(data, i);

    }

    private static double somma(int[] v, int size){
        int s = 0;
        for(int i = 0; i < size; i++)
            s += v[i];

        return s;
    }

    private static void solProf(int[] v, int vSize){
        
        
        int sum = 0;
        for (int i = 0; i < vSize; i++) 
           sum += v[i];
           
        double mean = ((double)sum) / vSize;  
        
        double sigma2 = 0;
        for (int i = 0; i < vSize; i++)
           sigma2 += (v[i] - mean) * (v[i] - mean);
           
        double sigma = Math.sqrt(sigma2 / vSize);   
     
        System.out.printf("media = %.2f \n", mean);
        System.out.printf("sigma = %.2f \n", sigma);     
    } 
}
