import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        if(false){
            String s = "Agent";
            System.out.println(s + s.length());
    
            s = "Mississippi";
            System.out.println(s.substring(1, 2));
            System.out.println(s.substring(2, s.length()-3));
    
    
            System.out.println("Francesco \r Totti");
            System.out.println("papereSiumSIUMA \r PAPERE");
    
    
            System.out.println("\f");
    
    
            // s = null;
            System.err.println(s.length());
    
    
            try {
                FileReader source = new FileReader("words.txt");
                Scanner file = new Scanner(source);
                PrintWriter outFile = new PrintWriter("words.txt");
    
                while(file.hasNextLine()){
                    outFile.println(file.nextLine() + " cipolla ");
                }
    
                file.close();
                outFile.close();
            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
            }
    
            String[] array = new String[0];
            for(String value: array)
                System.out.println(value);
                
    
            int[] first = {0, 1, 2, 3};
            int[] second = first;
            second[1] = 5;
            for(int value: first)
                System.out.println(value);
    
            System.out.println(fattoriale(5));
        }

        System.out.println("Length: " + strDist("cccatcowcatxx", "cat"));
    }

    private static int fattoriale(int n){
        if(n == 0)
            return 1;
        return n*fattoriale(n-1);
    }

    private static int strDist(String str, String sub) {
        int strLen = str.length();
        int subLen = sub.length();
        
        System.out.println(strLen);
        
        if(strLen < subLen)
            return 0;
        
        if(!str.substring(0, subLen).equals(sub))
            return strDist(str.substring(1),sub);
        
        if(!str.substring(strLen - subLen, strLen).equals(sub))
            return strDist(str.substring(0, strLen-1),sub);
        

        return strLen;
      }

}