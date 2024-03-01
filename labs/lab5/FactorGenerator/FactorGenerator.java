public class FactorGenerator {
    //var esemplare
    private int n;

    public FactorGenerator(int n) throws IllegalArgumentException{
        if(n>1) this.n=n;
        else throw new IllegalArgumentException();
    }//FactorGenerator

    public int nextFactor() throws IllegalStateException{
        int cont = 2;
        while(cont<=this.n){
            if((this.n % cont) == 0){
                this.n/=cont;
                return cont;
            }
            cont++;
        }
        throw new IllegalStateException();
    }//nextFactor

    public boolean hasNextFactor(){
        int cont = 2;
        while(cont<=this.n){
            if((this.n%cont) == 0)
                return true;
            cont++;
        }
        return false;
    }//hasNextFactor

}//FactorGenerator
