public class SavingAccount extends BankAccount {
    
    private double interest;
    public SavingAccount(double x)
    {
        interest=x;
    }
    public boolean changeInterest(double x)
    {
        if(x<=0)return false;
        interest = x;
        return true;
    }
    public boolean addInterest()
	{
		if(interest>0)
		{
			if(this.deposit(this.getBalance()*interest/100))
			{
				return true;
			}
			return false;
		}
		return false;
	}
}
