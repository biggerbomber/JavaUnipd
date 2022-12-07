public class CheckingAccount extends BankAccount
{


    private int transactionCount;
    public static final int FREE_TRANSACTIONS = 3;
    public static final double TRANSACTION_FEE = 2.0;
    
    public CheckingAccount()
    {
        super();               
        transactionCount = 0;  
    }

    public CheckingAccount(double initialBalance)
    {
        super(initialBalance); 
        transactionCount = 0;  
    }

    public CheckingAccount(double initialBalance, int initialTransCount)
    {
        super(initialBalance); 
        transactionCount = initialTransCount; 
    }

    public boolean deposit(double amount)  //SOVRASCRITTO
    {
        if(super.deposit(amount))
        { // aggiungi amount al saldo
        		transactionCount++;
        		return true;
        } 
        return false;       
    }

    public boolean withdraw(double amount) //SOVRASCRITTO
    {
        if(super.withdraw(amount))
        {
		   transactionCount++;
        		return true;
        }
        return false;// sottrai amount dal saldo
    } 

  
    public boolean deductFees()  //NUOVO METODO
    {
        if (transactionCount > FREE_TRANSACTIONS)
        {
            double fees = TRANSACTION_FEE *
                            (transactionCount - FREE_TRANSACTIONS);
            if(!super.withdraw(fees))
            {
            	return false;
            }
        }
        transactionCount = 0;
        return true;
    }


   

    public int getTransactionCount()
    {
        return transactionCount;
    }



    public String toString()
    {
	return "CheckingAccount[transactionCount="+transactionCount+"]"+super.toString();
    }
    public boolean equals(Object other)
    {
    	CheckingAccount b=(CheckingAccount)other;
    	
    	return (transactionCount==b.getTransactionCount())&&super.equals(other);
    } 




   
    

}
