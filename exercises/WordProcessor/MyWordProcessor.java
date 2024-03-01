import java.util.Scanner;

public class MyWordProcessor {
    private static final int INITIAL_SIZE = 100;
    private String[] v;
    private int vSize;

    public MyWordProcessor(){
        v = new String[INITIAL_SIZE];
        vSize = 0;
    }

    public int size(){
        return vSize;
    }

    public void add(String line){
        if(vSize == v.length)
            resize(v, 2*v.length);

        v[vSize] = line;
        vSize++;
    }

    private String[] resize(String[] v, int size){
        String[] newV = new String[size];
        System.arraycopy(v, 0, newV, 0, v.length);
        return newV;
    }

    public int wordSize(){
        int wordsCount = 0;
        for(int i = 0; i < this.size(); i++){
            Scanner line = new Scanner(v[i]);
            while(line.hasNext()){
                line.next();
                wordsCount++;
            }
            line.close();
        }
        return wordsCount;
    }

    public String[] toWords(){
        int wordsCount = wordSize();
        String[] words = new String[wordsCount];
        int j = 0;

        for(int i = 0; i < vSize; i++){
            Scanner line = new Scanner(v[i]);
            while(line.hasNext()){
                words[j] = line.next();
                j++;
            }
                
            line.close();
        }
            return words;
    }
    

    public String maxString(){
        String maxWord = "";


        for(int i = 1; i < vSize; i++){
            Scanner line = new Scanner(v[i]);
            while(line.hasNext()){
                String word = line.next();
                if(maxWord.compareTo(word) < 0)
                    maxWord = word;
            }
            line.close();
                
        }

        return maxWord;
    }


    public int findAndReplace(String find, String replace){
        int replaceCount = 0;

        for(int i = 0; i < vSize; i++){
            String[] line = v[i].split(" ");

            // sostituisco e conto le sost
            for(int j = 0; j < line.length; j++)
                if(line[j].equals(find)){
                    replaceCount++;
                    line[j] = replace;
                }
            
            // rimetto assieme la stringa
            String s = "";
            for(int j = 0; j < line.length; j++)
                s += " " + line[j];

            v[i] = s;                    
        }
        return replaceCount;
    }


    public String toString(){
        String s = "";
        
        for(int i = 0; i < vSize; i++)
            s+= v[i] + "\n";

        return s;
    }











}
