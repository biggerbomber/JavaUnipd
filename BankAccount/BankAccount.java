

public class BankAccount implements Comparable
{ 
	private double balance;
	public BankAccount()
	{ 
		balance = 0;
	}
	public BankAccount(double initialBalance)
	{ 
		balance = initialBalance;
	}
	public boolean deposit(double amount)
	{
		if(amount>0)
		{
		 	balance = balance + amount;
		 	return true;
		}else
		{
			return false;
		}
	}
	public boolean withdraw(double amount)
	{ 
		if(amount>0 && amount<=balance)
		{
			balance = balance - amount;
			return true;
		}else
		{
			return false;	
		}
	}
	
	public double getBalance()
	{ 
		return balance;
	}
	public boolean transfer(double amount, BankAccount other)
    	{ 
        	return(withdraw(amount) && other.deposit(amount));
        	
    	}
	public String toString()
    	{
		return "BankAccount[balance="+balance+"]"+super.toString();
    	}
   	public boolean equals(Object other)
   	{
    		BankAccount b=(BankAccount)other;
    		return balance==b.getBalance();
    }
	public int compareTo(Object other)
	{
		BankAccount b = (BankAccount)other;
		if(balance>b.balance) return 1;
		if(balance<b.balance) return -1;
		return 0;
	}	
}
