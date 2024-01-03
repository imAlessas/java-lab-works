public class TimeDepositAccount extends SavingsAccount {

    private int timeDeposit; 

    public TimeDepositAccount(double rate, int timeDeposit){
        super(rate);
        this.timeDeposit = timeDeposit;
    }

    public TimeDepositAccount(double balance, double rate, int timeDeposit){
        super(balance, rate);
        this.timeDeposit = timeDeposit;
    }

    public void withdraw(double amount){
        if(timeDeposit > 0)
            amount += 20;
        
        super.withdraw(amount);
    }

    
    public void addInterest() {
        super.addInterest();
        timeDeposit--;
    }

    public String toString(){
        return super.toString() + "[timeDeposit = " + timeDeposit + "]"; 
    }

    public boolean equals(Object otherAccount){
        return super.equals(otherAccount) 
            && this.timeDeposit == ((TimeDepositAccount)otherAccount).timeDeposit;
    }

    public int getTimeDeposit() {
        return timeDeposit;
    }



}
