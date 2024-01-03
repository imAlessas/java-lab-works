/*
    L'insieme C dei numeri complessi e' l'insieme delle coppie ordinate (x,y) 
    con x e y appartenenti a R (insieme dei numeri reali).
    Dato il numero complesso z = x + i *y,  i numeri reali x e y sono detti
    parte reale e parte immaginaria di z.
    Nei commenti che seguono, facciamo riferimento ai numeri complessi
        z = x + i*y, z1 = x1 + i*y1, z2 = x2 + i*y2
*/

public class MyComplex{
    
    private double re;
    private double im;

    // inizializza il numero complesso al valore 0 + i0 (zero complesso)
    public MyComplex(){
        this.re=0;
        this.im=0;
    }

    // inizializza il numero complesso al valore re + i*im
    public MyComplex(double realPart, double imagPart){
        this.re=realPart;
        this.im=imagPart;
    }

        //Restituisce la parte reale di un numero complesso
    public double getRe(){
        return re;  //completare
    }

    //Restituisce la parte complessa di un numero complesso
    public double getIm(){
        return im;  //completare
    }

    //Somma a questo numero complesso il numero complesso z
    //somma di due complessi: z = z1+z2 = (x1+x2) + i(y1+y2)
    public MyComplex add(MyComplex z){
        return new MyComplex(this.re+z.getRe(), this.im+z.getIm());
    }

    //Sottrae a questo numero complesso il numero complesso z
    //sottrazione di due complessi: z = z1-z2 = (x1-x2) +i(y1-y2)
    public MyComplex sub(MyComplex z){
        return new MyComplex(this.re-z.getRe(), this.im-z.getIm());
    }

    //Moltiplica questo numero complesso per il numero complesso z
    //prodotto di due complessi: z = z1*z2 = (x1*x2 -y1*y2) + i*(x1*y2 + x2*y1)
    public MyComplex mult(MyComplex z){
        double real= this.re*z.getRe() - this.im*z.getIm();
        double img= this.re*z.getIm()+this.im*z.getRe();
        return new MyComplex(real, img);
    }

    //Divide questo numero complesso per il numero complesso z
    //divisione fra due complessi: z1/z2 = z1 *1/z2, per z2 != 0
    public MyComplex div(MyComplex z){
        if(z.getRe()!=0 && z.getIm()!=0){
            return this.mult(z.inv()); 
        } else return null;
    }
          
    //Calcola il coniugato di questo numero complesso
    //coniugato del complesso z:  z^= x - i*y
    public MyComplex conj(){
        return new MyComplex(this.re, -this.im);
    }
          
    //Calcola l'inverso rispetto al prodotto di un numero complesso
    //inverso del complesso z: 1/z = x/(|z|*|z|) -i*y/(|z|*|z|), per z != 0
    public MyComplex inv(){
        if(this.re!=0 && this.im!=0){
            double denominator = Math.pow(this.mod(), 2);
            double real = this.re/denominator;
            double img = - this.im/denominator;
            return new MyComplex(real, img);
        }else return null;
    }

    //Calcola il modulo di questo numero complesso
    //modulo del complesso z: |z| = sqrt( x*x + y*y).
    public double mod(){
        return Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2));
    }
           
    //Confronta con tolleranza due numeri complessi.
    public boolean approxEquals(MyComplex z){
        return false;  //completare
    }

    //Crea una stringa che rappresenta questo numero complesso
    //Formato stringa: parte reale + i*parte immaginaria
    public String toString(){
        if(this.im<0) return this.re + " -i*"+Math.abs(this.im); 
        else return this.re + " + i*"+this.im; 

    }
}
