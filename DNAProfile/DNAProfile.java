import java.util.*;
import java.io.*;

public class DNAProfile
{
	
	public static void main(String [] args)
	{
		if(args.length!=2)
		{
			System.exit(1);	
		}	
		
		try(	FileReader fileSospetti = new FileReader(args[0]);
			FileReader fileCaso = new FileReader(args[1]);
			Scanner inputSospetti = new Scanner(fileSospetti);
			Scanner inputCaso  = new Scanner(fileCaso))
		{
			String DNACaso = inputCaso.nextLine();
			int vSizeSTR=0;
			String [] STR = new String[1];
			Scanner letturaSTR = new Scanner(inputSospetti.nextLine());
			if(!letturaSTR.next().equals("name"))
			{
				System.out.println("Formato non valido D:");
				System.exit(1);
			}
			
			int indexSTR=0;
			while(letturaSTR.hasNext())
			{
				if(vSizeSTR>=STR.length)
				{
					STR=resize(STR,vSizeSTR*2);
				}
				STR[indexSTR++]=letturaSTR.next();
				vSizeSTR++;
			}
			letturaSTR.close();
			int vSizeRipetizioniSTRCaso=0;
			int ripetizioniSTRCaso[]= new int[1];
			for(int i=0;i<vSizeSTR;i++)
			{
				if(vSizeRipetizioniSTRCaso>=ripetizioniSTRCaso.length)
				{
					ripetizioniSTRCaso=resize(ripetizioniSTRCaso,vSizeRipetizioniSTRCaso*2);
				}
				ripetizioniSTRCaso[i]=ripetizioni(STR[i],DNACaso);
				vSizeRipetizioniSTRCaso++;
			}
			boolean found = false;
			while(inputSospetti.hasNextLine())
			{
				Scanner sospettoIesimo = new Scanner(inputSospetti.nextLine());
				String nome = sospettoIesimo.next();
				
				for(int i=0;i<vSizeSTR;i++)
				{
					if(Integer.parseInt(sospettoIesimo.next())==ripetizioniSTRCaso[i])
					{
						found=true;
						break;
					}
				}
				if(found)
				{
					System.out.println("Il colpevole e' "+ nome);
					break;
				}
				
			}
			if(!found)
			{
				System.out.println("Il colpevole non e' tra i sospettati");
			}
			
			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("file not found D:");
			System.exit(1);
		}catch(IOException e)
		{
			System.out.println("errore D:");
			System.exit(1);
		}
					
	}
	private static int ripetizioni(String seq, String DNA)
	{
		int seqLength = seq.length();
		int maxRipetizioni=0;
		int currentRipetizioni=0;
		int i=0;
		//boolean consecutivo=false;
		while(i<DNA.length()-seqLength)
		{
			if(DNA.substring(i,i+seqLength).equals(seq))
			{
				currentRipetizioni++;
				if(currentRipetizioni>maxRipetizioni)
				{
					maxRipetizioni=currentRipetizioni;
				}
				i+=seqLength;
				
			}else
			{
				//consecutivo=false;
				currentRipetizioni=0;
				i+=1;
			}
		}
		return maxRipetizioni;
	}
	private static String [] resize(String [] old, int newSize)
	{
		String [] newArray = new String[newSize];
		for(int i=0;i<old.length&&i<newSize;i++)
		{
			newArray[i]=old[i];
		}
		return newArray;
	}
	private static int [] resize(int [] old, int newSize)
	{
		int [] newArray = new int[newSize];
		for(int i=0;i<old.length&&i<newSize;i++)
		{
			newArray[i]=old[i];
		}
		return newArray;
	}

}







