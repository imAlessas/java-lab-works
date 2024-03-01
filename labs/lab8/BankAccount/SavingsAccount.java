public class SavingsAccount extends BankAccount{

    private double interestRate;

    public SavingsAccount(double rate){
        super();
        interestRate = rate;
    }

    public SavingsAccount(double initialBalance, double rate){
        super(initialBalance);
        interestRate = rate;
    }

    public double getInterestRate(){   
        return interestRate;
    }

    //accredita gli interessi al termine del mese. Attenzione: usa il metodo
    //deposit della superclasse, altrimenti verrebbe addebitata la penale FEE
    public void addInterest() {
        super.deposit(getBalance() * interestRate / 100);
    }

    public String toString(){
        return super.toString() + "[interestRate=" + interestRate + "]";
    }

    public boolean equals(Object otherAccount){
        return super.equals(otherAccount) && this.interestRate == ((SavingsAccount)otherAccount).interestRate;
    }



    

}