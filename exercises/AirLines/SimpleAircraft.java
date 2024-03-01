/**
   Definisce un vettore aereo che puo' trovarsi in uno dei seguenti stati: <br>
   - MAINTENANCE il vettore e' in manutenzione<br>
   - LANDED il vettore e' a terra e non programmato per una rotta<br>
   - SCHEDULED il vettore e' a terra e programmato per una rotta aerea<br>
   - FLYING il vettore e' in volo<br>
   
   @author A. Luchetta
   @version 20201102

*/public class SimpleAircraft
{
    // costanti
    private static final String MAINTENANCE = "maintenance";
    private static final String LANDED = "landed";
    private static final String FLYING = "flying";
    private static final String SCHEDULED = "scheduled";
    private static final boolean ERROR = false;
    private static final boolean OK = !ERROR;
 
    // variabili di esemplare
    private String model;             // modello del vettore
    private String state;             // stato del vettore
    private double maxLength;         // massima distanza percorribile in volo
    private double maxHeight;         // massima quota raggiungibile in volo
    private SimpleAirRoute AirRoute;  // rotta programmata o in corso
    private double mileage;           // conta km
    private static double maxMileage; // soglia kilometrica per manutenzione
    private String airport;           // aeroporto di stazionamento
    
    /**
       inizializza un vettore aereo impostandolo nello stato LANDED con miglia
       percorse pari a zero
       @param m modello di questo vettore
       @param a aeroporto in cui si trova questo vettore 
       @param maxL massima lunghezza di rotta percorribile da questo vettore
       @param maxH massima quota raggiungibile da questo vettore
       @param maxKm valore di km percorsi oltre il quale questo vettore deve essere
              inviato alla manutenzione            
    */
    public SimpleAircraft(String m, String a, double maxL, double maxH, double maxKm)
    {
       model = m;
       state = LANDED;      
       maxLength = maxL;
       maxHeight = maxH;
       AirRoute = null;
       mileage = 0;     
       maxMileage = maxKm; 
       airport = a;
    }
    
    /**
       restituisce il chilometraggio accumulato dall'ultima manutenzione
       @return chilometraggio accumulato dall'ultima manutenzione
    */
    public double getMileage()
    {
       return mileage;
    }
    
    /**
       restituisce lo stato di questo vettore<br>
       stati ammessi: <br>
       MAINTENANCE il vettore e' in manutenzione<br>
       LANDED il vettore e' a terra in aeroporto<br>
       SCHEDULED il vettore e' programmato per una tratta aerea<br>
       FLYING il vettore e' in volo<br>
       @return stato di questo vettore
    */
    public String getState()
    {
       return state;
    }
    
    /**
       Se il vettore e' nello stato LANDED, se le caratteristiche della nuova
       rotta sono compatibili con questo vettore (lunghezza, massima altezza),
       e se il vettore e' nell'aeroporto di partenza della rotta, accetta la
       programmazione della rotta specificata e transita nello stato SCHEDULED
       @param ar la rotta specificata
       @return true se la programmazione e' andata a buon fine, false altrimenti
    
    */
    public boolean setSchedule(SimpleAirRoute ar)
    {
       if (ar == null)
          return ERROR;
 
       // verifiche per l'accettazione della rotta
       boolean wrongState = !state.equals(LANDED);
       boolean incompatibleAirRoute = maxLength < ar.getAirRouteLength()
                                       || maxHeight < ar.getAirRouteMaxAltitude();
       boolean wrongAirport = !airport.equals(ar.getFromAirport());                          
       
       if (wrongState || incompatibleAirRoute || wrongAirport)
          return ERROR;
          
       // accettazione della prenotazione
       AirRoute = ar;
       state = SCHEDULED;
       
       return OK;           
    }
    
    /**
       fa decollare questo vettore se lo stato di questo vettore e' SCEDULED
       @return true se questo vettore e' decollato, false altrimenti
    
    */
    public boolean takeOff()
    {
       if (!state.equals(SCHEDULED))
          return ERROR;
          
       state = FLYING;
       airport = "";
 
       return OK;         
    }
    
    /**
       se lo stato di questo vettore e' FLYING fa atterrare questo vettore, 
       aggiorna la distanza percorsa e l'aeroporto di stanza. Se la distanza
       percorsa eccede la distanza massima percorribile, questo vettore viene
       posto nello stato MAINTENANCE
       @return true se questo vettore e' atterrato, false altrimenti
    
    */
    public boolean land()
    {
       if (!state.equals(FLYING))
          return ERROR;
          
          state = LANDED;
          mileage += AirRoute.getAirRouteLength();
          airport = AirRoute.getToAirport();
          AirRoute = null;
          
          if (mileage > maxMileage)
             goHangar();
             
          return OK;   
    }
    
    /**
       se lo stato di questo vettore e' diverso da FLYING, invia il vettore alla
       manutenzione, azzera la distanza percorsa e cancella l'eventuale
       prenotazione di rotta
       @return true se questo vettore ha raggiunto lo stato MAINTENANCE, false altrimenti
    
    */
    public boolean goHangar()
    {
       if (state.equals(FLYING))
          return ERROR;
          
        state = MAINTENANCE;
        mileage = 0;
        AirRoute = null;
 
        return OK;     
    } 
    
    public String toString()
    {
       String location = " | airport " + airport + " |";      
       if(state.equals(FLYING))
          location = " to airport " + AirRoute.getToAirport() + " |";
          
       return "Aircraft " + model + " | state = " + state + location
                 + " mileage = " + mileage + " km";
    }    
 }