import java.util.Scanner;
import java.io.*;

public class TestScanner 
{
	public static void main (String [] args)
	{
		if(args.length !=2)
		{
			System.out.println("Mi servono i nomi di DUE file");
			System.exit(1);
		}
		
		try(FileReader input=new FileReader(args[0]);
		Scanner in= new Scanner(input);
		PrintWriter output = new PrintWriter(args[1]))
		{
			
			while(in.hasNextLine())
			{
				String temp2= in.nextLine();
				Scanner riga = new Scanner(temp2);
				riga.useDelimiter("[\'\\s]+");
				while(riga.hasNext())
				{
					String temp=riga.next();
					output.print(temp.substring(0,1).toUpperCase()+temp.substring(1).toLowerCase()+( (temp.substring(1).length()==0)? "'":" "));
				}
				output.print('\n');
				
			}
			
			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("errore");
		}catch(IOException e)
		{
			System.out.println("errore2");
		}	
		
		
	}
}

