import java.util.*;
import java.io.*;

public class InRovesciato
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int indexNomiFile=0;
		String [] nomi= new String[2];
		while(indexNomiFile<2&&in.hasNext())
		{
			nomi[indexNomiFile++]=in.next();
		}
		
		if(indexNomiFile!=2)
		{
			System.exit(1);
		}
		
		try(	FileReader inputFile = new FileReader(nomi[0]);
			PrintWriter outputFile = new PrintWriter(nomi[1]);
			Scanner inputStream = new Scanner(inputFile))
		{
		
			while(inputStream.hasNextLine())
			{
				outputFile.println(rovescia(inputStream.nextLine()));
			}
			
		}catch(FileNotFoundException e)
		{
			System.out.println("non trovo il file D:");
		}catch(IOException e)
		{
			System.out.println("gran errore D:");
		}
		
		in.close();
	}
	
	public static String rovescia(String in)
	{
		String out = "";
		for(int i=in.length()-1;i>=0;i--)
		{
			out+=in.charAt(i);
		}
		return out;
	}	
}






