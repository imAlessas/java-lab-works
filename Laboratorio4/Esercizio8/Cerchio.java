public class Cerchio{

    private double x;
    private double y;
    private double r;

   //Construttore della classe Cerchio: centro (x,y) e raggio
   public Cerchio (double x, double y, double r){
       this.x=x;
       this.y=y;
       this.r=r;
   }

   public double getX(){
       return x;
    }

   public double getY(){
       return y;
    }

   public double getR(){
       return r;
    }

   // Verifica se questo cerchio e il cerchio c sono coincidenti, ovvero se hanno tutti i punti in comune
    public boolean isCoincident(Cerchio c){
       return this.x==c.getX() && this.y==c.getY() && this.r==getR();
   }


   //verifica se questo cerchio e' interno al cerchio c o se il cerchio c e' interno a questo cerchio
   public boolean isEncircled(Cerchio c){
       return this.x==c.getX() && this.y==c.getY() && this.r>getR();
   }

   /*
      verifica se questo cerchio e il cerchio c sono esterni, ovvero non
      sono contenuti uno nell'altro e non hanno alcun punto in comune
   */
   public boolean isExternal(Cerchio c){
	//... completare
   }
          


   /*
      verifica se questo cerchio e il cerchio c sono secanti, 
      ovvero se hanno almeno un punto in comune.
   */
   public boolean isSecant(Cerchio c){
	//... completare
   }
          


   /*
      Verifica se questo cerchio e il cerchio c sono tangenti,
      ovvero se hanno un solo punto in comune
   */
   public boolean isTangential(Cerchio c){
	//... completare
   }
}