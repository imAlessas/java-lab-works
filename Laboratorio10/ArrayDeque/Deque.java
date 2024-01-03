public interface Deque extends Container{
   /* Aggiunge l'oggetto Object all'inizio. 
      Lancia FullDequeException se la coda doppia e` piena */
   void addFirst(Object obj);

   /* Aggiunge l'oggetto Object alla fine. 
      Lancia FullDequeException se la coda doppia e` piena */
   void addLast(Object obj);

   /* Rimuove l'oggetto che si trova all'inizio e lo restituisce. 
      Lancia EmptyDequeException se la coda doppia e` vuota */
   Object removeFirst();

   /* Rimuove l'oggetto che si trova alla fine e lo restituisce. 
      Lancia EmptyDequeException se la coda doppia e` vuota */
   Object removeLast();

   /* Ispeziona l'oggetto che si trova all'inizio e lo restituisce, ma non
      lo rimuove. 
      Lancia EmptyDequeException se la coda doppia e` vuota */
   Object getFirst();

   /* Rimuove l'oggetto che si trova alla fine e lo restituisce, ma non
      lo rimuove.  
      Lancia EmptyDequeException se la coda doppia e` vuota */
   Object getLast();

   /* Restituisce la dimensione della coda doppia, ovvero il numero di  
      oggetti contenuti nella coda doppia */
   int size();

}

class EmptyDequeException extends RuntimeException { }
class FullDequeException extends RuntimeException { }
