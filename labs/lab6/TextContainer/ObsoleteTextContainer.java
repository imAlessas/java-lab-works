// import java.util.Scanner;

// public class ObsoleteTextContainer{

//     private String[] text;
//     private int vSize;
//     private static final int INITSIZE = 100;

//     //costruttore di un contenitore di testo vuoto
//     public ObsoleteTextContainer(){
//         text = new String[INITSIZE];
//         vSize = 0;
//     }

//     /*
//       verifica se il testo e` vuoto, restituisce
//       true se l'oggetto non contiene testo, false altrimenti
//     */
//     public boolean isEmpty(){
//         return vSize==0;
//     }

//     /*
//       aggiunge la stringa "stringa" in coda al testo. Termina senza errori
//       se String stringa e` uguale a null.
//     */
//     public void add(String stringa){
//         if(vSize == text.length)
//             resize(2*text.length);
//         text[vSize] = stringa;
//         vSize++;
//     }

//     private void resize(int size){
//         String[] newText = new String[size];
//         System.arraycopy(text, 0, newText, 0, vSize);
//         text = newText;
//     }

//     //conta e restituisce il numero di stringhe nel testo
//     public int count(){
//         return vSize;
//     }

//     /*
//      separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
//      TextContainer in cui tutte le parole sono separate, e ne restituisce il
//      riferimento. Usa l'insieme di delimitatori di default di Scanner, ovvero
//      "\p{JavaWhitespace" (si veda la documentazione di Scanner, in particolare
//      dei metodi delimiter e useDelimiter, e la documentazione della classe
//      Pattern)
//     */
//     public TextContainer splitWords(){
//         TextContainer words = new TextContainer();

//         for(int i = 0; i < vSize; i++){
//             Scanner getWord = new Scanner(text[i]);

//             while(getWord.hasNext())
//                 words.add(getWord.next());
            
//             getWord.close();
//         }
//         return words;
//     }

//     /*
//      separa le stringhe del testo in parole. Crea un nuovo oggetto di classe
//      TextContainer in cui tutte le parole sono separate, e ne restituisce il
//      riferimento. Usa l'insieme di delimitatori specificato dalla stringa delim
//      (si veda la documentazione di Scanner, in particolare dei metodi delimiter
//      e useDelimiter, e la documentazione della classe Pattern)
//     */
//     public TextContainer splitWords(String delim){
//         TextContainer words = new TextContainer();

//         for(int i = 0; i < vSize; i++){
//             Scanner getWord = new Scanner(text[i]);
//             getWord.useDelimiter(delim);
            
//             while(getWord.hasNext())
//                 words.add(getWord.next());
            
//             getWord.close();
//         }
//         return words;
//     }

//     /*
//      Rimuovi tutte le occorrenze della stringa "stringa".
//      - Se la stringa compare piu` volte vengono eliminate tutte le occorrenze.
//      - Lancia IllegalArgumentException se il parametro esplicito e` null.
//      Attenzione: si devono scandire tutte le stringhe del testo perche`
//      la parola da cancellare puo` comparire piu` volte nel testo.
//     */
//     public void remove(String stringa) throws IllegalArgumentException{
//         if(stringa == null)
//             throw new IllegalArgumentException();

//         TextContainer newText = new TextContainer();
//         for(int i = 0; i < vSize; i++){
//             if(!text[i].equals(stringa))
//                 newText.add(text[i]);
//         }    
//         text = newText.text;
//     }

//     /*
//       Restituisce il numero di occorrenze nel testo della stringa "stringa".
//       Lancia IllegalArgumentException se il parametro esplicito e` null.
//     */
//     public int frequency(String stringa) throws IllegalArgumentException{
//         if(stringa == null)
//             throw new IllegalArgumentException();

//         int cont = 0;
//         for(int i = 0; i < vSize; i++)
//             if(text[i].equals(stringa))
//                 cont++;

//         return cont;
//     }

//     /*
//       restituisce la stringa che compare piu` volte nel testo (frequenza massima).
//       Se piu` stringhe hanno frequenza massima, ne restituisce una qualsiasi.
//       Se il testo e` vuoto restituisce null.
//     */
//     public String maxFrequency(){
//         if(isEmpty())
//             return null;
//         String max = text[0];
//         for(int i = 1; i < vSize; i++)
//             if(frequency(text[i]) > frequency(max))
//                 max = text[i];

//         return max;
//     }

//     /*
//       restituisce la prima stringa del testo in ordine lessicografico.
//       Se il testo e` vuoto restituisce null.
//     */
//     public String min(){
//         if(isEmpty())
//             return null;

//         String min = text[0];
//         for(int i = 1; i < vSize; i++)
//             if(min.compareTo(text[i]) > 0)
//                 min = text[i];

//         return min;
//     }

//     /*
//       restituisce l'ultima stringa del testo in ordine lessicografico.
//       Se il testo e` vuoto restituisce null.
//     */
//     public String max(){
//         if(isEmpty())
//             return null;
        
//         String max = text[0];
//         for(int i = 1; i < vSize; i++)
//             if(max.compareTo(text[i]) < 0)
//                 max = text[i];

//         return max;
//     }

//     /*
//       trasforma il testo in stringa. Viene inserito un carattere di nuova riga (\n)
//       fra le stringhe. Se il testo e` vuoto restituisce la stringa vuota "".
//     */
//     public String toString(){
//         String s = "";

//         for(int i = 0; i < vSize; i++)
//             s += text[i] + "\n";
//         return s;

//     }

//     /*
//       crea un nuovo oggetto di tipo TextContainer in cui tutti i caratteri non
//       alfabetici sono stati eliminati dalle stringhe del testo. Ad esempo elimina
//       la punteggiatura, i numeri, le parentesi. Usa il metodo
//       java.lang.Character.isLetter(char c)
//     */
//     public TextContainer onlyLetters(){
//         TextContainer letters = new TextContainer();

//         for(int i = 0; i < vSize; i++){
//             String s = "";
//             Scanner getWord = new Scanner(text[i]); // prendo la stringa e la uso nello scanner per splittarla
            
            
//             while(getWord.hasNext()){
//                 String word= getWord.next(); // prendo la n_esima parola

//                 for(int j = 0; j < word.length(); j++)
//                     if(Character.isLetter(word.charAt(j))) // se il carattere j_esimo della parola è una lettera la prendo
//                         s += word.charAt(j);
//             }
//             letters.add(s);
//             getWord.close();
//         }
//         return letters;
//     }

//     /*
//      crea un nuovo oggetto di tipo TextContainer nel quale tutti i caratteri
//      maiuscoli sono stati convertiti in minuscoli.
//     */
//     public TextContainer toLowerCase(){
//         TextContainer newText = new TextContainer();

//         for(int i = 0; i < vSize; i++)
//             newText.add(text[i].toLowerCase());

//         return newText;
//     }

//     //crea una copia dell'oggetto TextContainer, e ne restituisce il riferimento
//     public TextContainer copy(){
//         TextContainer newText = new TextContainer();

//         for(int i = 0; i < vSize; i++)
//             newText.add(text[i]);

//         return newText;
//     }

// }