public class MySimpleAircraft {
    private final String modello;
    private final double maxKilometri;
    private final double maxLunghezza;
    private final double maxQuota;
    private String stato; /* MAINTENANCE, LANDED, SCHEDULED, FLYING */
    private String aereoporto;
    private double kilometri;
    private SimpleAirRoute rottaPrenotata;

    public MySimpleAircraft(String modello, 
                        String aereoporto, 
                        double maxLunghezza, 
                        double maxQuota, 
                        double maxKilometri){
        this.modello = modello;
        this.maxLunghezza = maxLunghezza;
        this.maxQuota = maxQuota;
        this.maxKilometri = maxKilometri;
        this.aereoporto = aereoporto;

        rottaPrenotata = null;
        stato = "LANDED";
        kilometri = 0;

    }

    public double getMilage(){
        return kilometri;
    }

    public String getState(){
        return stato;
    }

    public boolean setSchedule(SimpleAirRoute ar){
        if(ar.getAirRouteLength() < maxLunghezza &&
            ar.getAirRouteMaxAltitude() < maxQuota &&
            ar.getFromAirport().equals(aereoporto) &&
            kilometri < maxKilometri &&
            stato.equals("LANDED")){
                rottaPrenotata = ar;
                stato = "SCHEDULED";
                return true;
            }
        return false;
    }

    public boolean takeOff(){
        if(stato.equals("SCHEDULED")){
            stato = "FLYING";
            aereoporto = "";
            return true;
        } return false;
    }

    public boolean land(){
        if(stato.equals("FLYING")){
            stato = "LANDED";
            aereoporto = rottaPrenotata.getToAirport();
            kilometri += rottaPrenotata.getAirRouteLength();
            rottaPrenotata = null;

            if(kilometri > maxKilometri)
                stato = "MAINTENANCE";

        } return false;
    }

    public boolean goHangar(){
        if(!stato.equals("FLYING")){
            stato = "MAINTENANCE";
            kilometri = 0;
            rottaPrenotata = null;

            return true;
        } return false;
    }

    public String toString(){
        String location = " | airport " + aereoporto + " |";      
        if(stato.equals("FLYING"))
           location = " to airport " + rottaPrenotata.getToAirport() + " |";
           
        return "Aircraft " + modello + " | state = " + stato + location
                  + " mileage = " + kilometri + " km. \n\n";    
                
        }

}
