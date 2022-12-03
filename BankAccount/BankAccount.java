
public class BankAccount
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
	public String toString()
	{ 
		return "BankAccount: saldo corrente pari a "+balance;
	}
}
