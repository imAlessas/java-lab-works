public class BankAccount{

    private double balance;

    public BankAccount(){
        balance = 0;
    }

    public double getBalance(){   
        return balance;
    }

    public BankAccount(double initialBalance){   
        deposit(initialBalance);
    }

    public void deposit(double amount){
        if (amount <= 0)
            throw new IllegalArgumentException();
        balance = balance + amount;
    }

    public void withdraw(double amount){
        if (amount > balance || amount <= 0)
            throw new IllegalArgumentException();
        balance = balance - amount;
    }

    public void transfer(double amount, BankAccount other){ 
        withdraw(amount);
        other.deposit(amount);
    }

    public String toString(){
        return getClass().getName() + "[balance = " + balance + "]";
    }

    // devo prima castare l'oggetto per poi usarne i metodi
    public boolean equals(Object otherAccount){
        return this.balance == ((BankAccount)otherAccount).balance;
    }



}
