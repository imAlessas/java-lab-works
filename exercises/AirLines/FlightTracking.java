public class FlightTracking{
   public static void main(String[] args){
      final String AIRPORT1 = "ROMA FCO";
      final String AIRPORT2 = "TOKYO NRT";
      final String AIRPORT3 = "LONDON LHR";
      
      final int LENGTH1 = 9500;
      final int LENGTH2 = 10000;   
      final int LENGTH3 = 1500;   
      
      final int HEIGHT1 = 11000;
      final int HEIGHT2 = 11500;   
      final int HEIGHT3 = 9000;  
      
      final String MODEL1 = "BOING 737";
      final double MAX_LENGTH1 =   8500;
      final double MAX_HEIGHT1 =  11000;
      final double MAX_MILEAGE1 = 18000;
            
      final String MODEL2 = "AIRBUS A340";
      final double MAX_LENGTH2 =  10000;
      final double MAX_HEIGHT2 =  12000;
      final double MAX_MILEAGE2 = 20000;      
      
      // generazione delle rotte
      SimpleAirRoute AirRoute1 = new SimpleAirRoute(AIRPORT2, AIRPORT1, LENGTH1, HEIGHT1);             
      SimpleAirRoute Airroute2 = new SimpleAirRoute(AIRPORT1, AIRPORT3, LENGTH3, HEIGHT3);           
      SimpleAirRoute Airroute3 = new SimpleAirRoute(AIRPORT3, AIRPORT2, LENGTH2, HEIGHT2); 
      
      // generazione dei vettori aerei
      MySimpleAircraft b737 = new MySimpleAircraft(MODEL1, AIRPORT1, MAX_LENGTH1, MAX_HEIGHT1, MAX_MILEAGE1);
      System.out.println(b737);
   
      MySimpleAircraft a340 = new MySimpleAircraft(MODEL2, AIRPORT2, MAX_LENGTH2, MAX_HEIGHT2, MAX_MILEAGE2);      
      System.out.println(a340);

      // prenotazione 1 del Vettore a340
      boolean b = a340.setSchedule(AirRoute1);     // prenotazione 
      System.out.println("1S " + a340);
      System.out.println("1S " + AirRoute1);
      
      // volo 1 del vettore a340
      a340.takeOff();
      System.out.println("1F " + a340);
      System.out.println("1F " + AirRoute1);
            
      // atteraggio 1 del vettore a340
      a340.land();
      System.out.println("1L " + a340);  
      
      // prenotazione 2 del Vettore a340
      a340.setSchedule(Airroute2); 
      System.out.println("2S " + a340); 
      System.out.println("2S " + Airroute2);      
      
      // volo 2 del vettore a340
      a340.takeOff();
      System.out.println("2F " + a340);
      
      // atteraggio 2 del vettore a340
      a340.land();
      System.out.println("2L " + a340);
      
      // prenotazione 3 del Vettore a340
      a340.setSchedule(Airroute3); 
      System.out.println("3S " + a340);
      System.out.println(Airroute3);       
      
      // volo 3 del vettore a340
      a340.takeOff();
      System.out.println("3F " + a340);
      
      // atteraggio 3 del vettore a340
      a340.land();
      System.out.println("3L " + a340);     
      
      // prenotazione 1 del Vettore b737
      b737.setSchedule(Airroute2);
      System.out.println(b737);
      System.out.println(Airroute2);                                                 
   }
}