public class RecSubstringGenerator {

    private static String recursive(String s){
        if(s.length() == 1)
            return s;
            
        return  recursive(s.substring( 0, s.length()-1 )) + " " + s;        
    }

    // questo metodo funziona come un ciclo for: 
    // ogni vo,ta che viene invocato, prende la prima stringa e ne calcola le sottostringhe
    // dopo di che prende la sottostringa della prima (tranne il 1 carattere) e si richiama
    private static String startRecursive(String s){
        if(s.length()==1)
            return s; 

        String s1 = recursive(s);
        String s2 = s.substring(1);

        return s1 + " " + startRecursive(s2);
    }


    public static void main(String[] args) {
        System.out.println(startRecursive("ciao"));
    }
}