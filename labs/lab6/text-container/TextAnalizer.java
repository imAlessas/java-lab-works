public class TextAnalizer {

    public static void prova(){
        TextContainer text = new TextContainer();

        text.add("Ciao come stai.");
        text.add("Ciao come stai.");
        text.add("Io sto molto bene!");
        text.add("Posso infatti urlare SUUUUUUUUUUUUU. ");
        text.add("Tu puoi farlo? NON PENSO PROPRIO");
        text.add("Ciao come stai.");
        text.add("Io sto molto bene!");
        text.add("vabbè dai, ti do il mio numero cosi mi chiami: 347 535 6191");

        System.out.println(text.isEmpty());
        System.out.println(text.count());

        System.out.println(text);
        System.out.println();
        System.out.println("Min: " + text.min());
        System.out.println();
        System.out.println("Max: " + text.max());
        System.out.println();
        System.out.println(text.frequency("Io sto molto bene!"));
        System.out.println();
        System.out.println("Max freq:" + text.maxFrequency());
        System.out.println();

        text.remove("Ciao come stai.");
        System.out.println("Remove");
        System.out.println(text);

        TextContainer lower = text.toLowerCase();
        System.out.println("Lower");
        System.out.println(lower);

        TextContainer letters = text.onlyLetters();
        System.out.println("Letters");
        System.out.println(letters);

        TextContainer words = text.splitWords();
        System.out.println("Split words");
        System.out.println(words);

        TextContainer wordsDelim = text.splitWords("a");
        System.out.println("Split words");
        System.out.println(wordsDelim);
    }
    public static void main(String[] args) {
        TextContainer text = new TextContainer();
        text.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        text.add("Nulla congue turpis mattis tellus tempus, nec posuere nibh pharetra.");
        text.add("Praesent suscipit ligula pellentesque erat rhoncus, id dignissim nisl accumsan.");
        text.add("Suspendisse hendrerit dolor vitae fringilla posuere.");
        text.add("Ut sit amet sem lacinia, sollicitudin nisi sit amet, aliquet lorem.");
        text.add("Fusce et erat et urna lacinia cursus ac sed elit.");

        TextContainer words = text.splitWords(); //separo il teso in parole
        words = words.onlyLetters(); //tengo solo le lettere
        words = words.toLowerCase(); //tutto minuscolo

        System.out.println("----- Testo originale -----");
        System.out.println(text);
        System.out.println("----- Numero parole -----");
        System.out.println(words.count());
        System.out.println("----- Prima parola lessicografica -----");
        System.out.println(words.min());
        System.out.println("----- Ultima parola lessicografica -----");
        System.out.println(words.max());

        String[] mostFrequent = new String[5];

        for(int i = 0; i < mostFrequent.length; i++){
            mostFrequent[i] = words.maxFrequency();
            words.remove(mostFrequent[i]);
        }



        System.out.println("----- 5 parole più frequenti -----");
        for(int i = mostFrequent.length -1; i >= 0; i--)
            System.out.println((i+1) + ". " + mostFrequent[i]);


        prova();
    }
}
