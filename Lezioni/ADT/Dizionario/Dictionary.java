public interface Dictionary extends Container{
    /* L'inserimento va sempre a buon fine
        1. se la chiave non esiste viene aggiunta
        2. se la chiave esiste, il valore a lei associato è sovrascritto
        3. se la chiave è null, throw new IllegaArgEx();  */
    void insert(Comparable key, Object value); 

    /* La rimozione della chiava comporta anche la rimozione del valore
        Se la chiave non esiste lancia DictionaryItemNotFoundException */
    void remove(Comparable key);

    /* Data una chiave restituisce il valore ad esse collegato
        Se la chiave non esiste lancia DictionaryItemNotFoundException */
    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException{}
