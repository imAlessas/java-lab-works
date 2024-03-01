public class RecStringReverser {

    private static String reverseString(String s, int length){
        if(s.length() == 0)
            return "";
        length--;
        return s.charAt(length) + reverseString(s.substring(0, length), length);
    }

    public static void main(String[] args) { 
        String s=args[0];
        System.out.println(reverseString(s, s.length()));
    }
}
