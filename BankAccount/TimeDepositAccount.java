public class TimeDepositAccount extends SavingAccount
{
	private int mesiRimanenti;
	private final int PENALE=20;
	public TimeDepositAccount(double interest,int mesi)
	{
		super(interest);
		mesiRimanenti=mesi;
	
	}
	public TimeDepositAccount(double balance,double interest,int mesi)
	{
		super(balance,interest);
		mesiRimanenti=mesi;
	}
	public boolean addInterest()     //NUOVO METODO
    	{
    		if(mesiRimanenti>0)mesiRimanenti--;
        	return super.addInterest();
   	}
	public int getMonthsLeft()
	{
		return mesiRimanenti;
	}
	public String toString()
    	{
		return "TimeDepositAccount[mesiRimanenti="+mesiRimanenti+"]"+super.toString();
    	}
    	public boolean equals(Object other)
    	{
    		TimeDepositAccount b=(TimeDepositAccount)other;
    		return (mesiRimanenti==b.getMonthsLeft())&&super.equals(other);
   	} 
   	public boolean withdraw(double amount)
    	{
    		if(mesiRimanenti>0)
    		{
    			return(super.withdraw(amount+PENALE));
    			
    		}
     	return super.withdraw(amount);
    	}
}






