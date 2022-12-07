public class SavingAccount extends BankAccount {
    
    	private double interest;
    	
    	
    	public SavingAccount(double x)
    	{
    		super();
        	interest=x;
    	}
    	
    	
    	public SavingAccount(double initialBalance, double rate)
    	{
       		super(initialBalance); 
			interest = rate;
    	}
    	
    	
    	public boolean changeInterest(double x)
    	{
        	if(x<=0)return false;
        	interest = x;
        	return true;
    	}
    	
    		
    	public boolean addInterest()
	{
		return super.deposit(getBalance() * interest / 100);
	}
	
	
	public double getInterestRate()
    	{   
        	return interest;
    	}
    	
    	
    	public String toString()
    	{
		return "SavingAccount[interestRate="+interest+"]"+super.toString();
    	}
    	
    	
    	public boolean equals(Object other)
    	{
    		SavingAccount b=(SavingAccount)other;
    	
    		return (interest==b.getInterestRate())&&super.equals(other);
    	}
}


