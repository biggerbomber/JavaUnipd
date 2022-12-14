import java.util.Scanner;
import java.util.*;
import java.io.*;
public class SpellingBeeGame
{
	
	public static void main (String [] args)
	{
		
		ComparableSet parole= new ComparableSet();
		System.out.println("Caricamento parole.......");
		try(	FileReader r = new FileReader("parole.txt");
			Scanner input=new Scanner(r))
		{
			while(input.hasNextLine())
			{
				parole.add(input.nextLine().toLowerCase());
			}
			
			
		}catch(IOException e)
		{
			System.out.println("errore input");
			System.exit(1);
		
		}
		
		System.out.println("Gioco pronto, Generazione lettere");
		ComparableSet lettere = new ComparableSet();
		String letteraGialla = generaLettere(lettere);
		
		System.out.println("Lettere che puoi utilizzare : "+printArray(lettere.toArray()));
		//System.out.println(printArray(parole.toArray()));
		System.out.println("lettera che devi usare: "+letteraGialla);
		System.out.println("Per rigenerare lettere scrivi \"-r\", Per uscire scrivi \"-quit\"");
		Scanner in = new Scanner(System.in);
		String inp=";";
		do
		{
			
			inp = in.nextLine();
			if(!inp.substring(0,1).equals("-"))
			{
				boolean valido = true;
				boolean gialla =false;
				for(int i=0;i<inp.length();i++)
				{
					if(!lettere.contains(inp.charAt(i)+"") && !letteraGialla.equals(inp.charAt(i)+""))
					{
						valido = false;
					}
					if(letteraGialla.equals(inp.charAt(i)+""))
					{
						gialla=true;
					}
				}
				valido = valido && gialla;
				if(parole.contains(inp)&&valido)
				{
					System.out.println("Parola Corretta");
				}else if(!valido)
				{
					System.out.println("la parola non soddisfa i requisiti");
				}else
				{
					System.out.println("parola non esistente");
				}
					
			
			}else if(inp.equals("-r"))
			{
				lettere.makeEmpty();
				letteraGialla = generaLettere(lettere);
				System.out.println("Lettere che puoi utilizzare : "+printArray(lettere.toArray()));
				//System.out.println(printArray(parole.toArray()));
				System.out.println("lettera che devi usare: "+letteraGialla);
				System.out.println("Per rigenerare lettere scrivi \"-r\", Per uscire scrivi \"-quit\"");
			}
		
		}while(!inp.equals("-quit"));
		

	}
	public static String generaLettere(ComparableSet set)
	{
		String [] vocali = {"a","e","i","o","u"};
		for(int i=0;i<2;)
		{
			String vocale = vocali[(int)(vocali.length*Math.random())];
			if(!set.contains(vocale))
			{
				set.add(vocale);
				i++;
			}	
		}
		for(int i=0;i<=4;)
		{
			String lett = ""+(char)(int)('a'+('z'-'a'+1)*Math.random());
			if(!set.contains(lett))
			{
				if(i==4)
				{
					return lett;
				}
				set.add(lett);
				i++;
			}
		}
		return "p";
		
		
		
	}
	public static String printArray(Object[] v)
	{
		if(v==null)return "null";
		return printArray(v,v.length);
	}
	public static String printArray(Object[] v, int vSize)
	{
		if(vSize==0){return "[]";}
		String output="["+v[0];
		
		for(int i=1;i<vSize;i++)
		{
			output+=" "+v[i];
		}
		output+="]";
		
		return output;
	}
	
}





