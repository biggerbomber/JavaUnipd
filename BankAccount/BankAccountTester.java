import java.util.Scanner;

public class BankAccountTester
{
	public static void main(String [] ARGS)
	{
		
		Scanner input=new Scanner(System.in);
		String comando;
		SavingAccount b= new SavingAccount(0);
		do
		{
			System.out.println("Comando? (Q, B, D, W, A)");
			String istruzione= input.nextLine();
			comando=istruzione.substring(0,1);
			Scanner parametri= new Scanner(istruzione.substring(1));
			if(parametri.hasNext() && istruzione.substring(1).length()>0)
			{
				if(istruzione.substring(1).charAt(0)!=' ')continue;
				try
				{
					String param = parametri.next();
					if(parametri.hasNext())continue;
					
					if(comando.equalsIgnoreCase("D"))
					{
						if(b.deposit(Double.parseDouble(param)))
						{
							System.out.println("ok");
						}else
						{
							System.out.println("ladruncolo");
						}
					}else if(comando.equalsIgnoreCase("W"))
					{	
						if(b.withdraw(Double.parseDouble(param)))
						{
							System.out.println("ok");
						}else
						{
							System.out.println("ladruncolo");
						}
					
					}else if(comando.equalsIgnoreCase("A"))
					{
						if(b.changeInterest(Double.parseDouble(param)))
						{
							b.addInterest();
							System.out.println("ok");
						}else
						{
							System.out.println("ladruncolo");
						}
					}
				}catch(NumberFormatException e)
				{
					continue;
				}
	
			}else
			{
				if(comando.equalsIgnoreCase("B"))
				{
					System.out.println(b.getBalance());
				}
			}
			 
		}while(!comando.equalsIgnoreCase("Q"));
	}
}
