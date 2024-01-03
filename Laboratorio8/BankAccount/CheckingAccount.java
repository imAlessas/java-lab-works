public class CheckingAccount extends BankAccount{

    private int transactionCount;
    public static final int FREE_TRANSACTIONS = 3;
    public static final double TRANSACTION_FEE = 2.0;

    public CheckingAccount(){
        super();               
        transactionCount = 0;  // azzera conteggio transaz.
    }

    public CheckingAccount(double initialBalance){
        super(initialBalance); 
        transactionCount = 0;  // azzera conteggio transaz.
    }

    public CheckingAccount(double initialBalance, int initialTransCount){
        super(initialBalance); 
        transactionCount = initialTransCount; // transazioni iniziali
    }


    public void deposit(double amount){
        super.deposit(amount); // aggiungi amount al saldo
        transactionCount++;        
    }

    public void withdraw(double amount){
        super.withdraw(amount); // sottrai amount dal saldo
        transactionCount++;
    } 

    // applica le commissioni sulle operazioni in eccedenza
    public void deductFees(){
        if (transactionCount > FREE_TRANSACTIONS)
        {
            double fees = TRANSACTION_FEE *
                            (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }


    // ------- metodi di accesso --------

    public int getTransactionCount(){
        return transactionCount;
    }

    public String toString(){
        return super.toString() + "[transactionCount = " + transactionCount + "]";
    }

    public boolean equals(Object otherAccount){
        return super.equals(otherAccount) && this.transactionCount == ((CheckingAccount)otherAccount).transactionCount;
    }
    
}