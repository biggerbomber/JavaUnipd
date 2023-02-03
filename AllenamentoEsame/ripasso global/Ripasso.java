import java.util.*;
import java.io.*;

public class Ripasso
{
	public static void main (String [] args)
	{
		if(args.length!=2){
			System.out.println("Iserisi du efile da riga di comando");
			System.exit(1);
		
		}

		
		String [] righe= new String[2];
		int vSize=0;
		try(FileReader fileLettura = new FileReader(args[0]);
			Scanner input = new Scanner(fileLettura);){
			while(input.hasNextLine()){
				if(vSize==righe.length){
					
					righe = resize(righe, vSize*2);
				
				}
				righe[vSize++]=input.nextLine();
			}
		
		
		}catch(FileNotFoundException e)
		{
			System.out.println("File non trovato");
			System.exit(1);
		
		}catch(IOException e)
		{
			System.out.println("File non trovato");
			System.exit(1);
		
		}
		
		for(int i=0;i<vSize;i++)
		{
			Scanner token = new Scanner(righe[i]);
			String result=null;
			while(token.hasNext()){
				String parola = token.next();
				if(result==null){
					result=parola.toUpperCase();
				}else{
					result+=" "+parola.toUpperCase();
				}
			}
			righe[i]=result;
		}
		try(PrintWriter fileScrittura = new PrintWriter(args[1]);)
		{
			for(int i=0;i<vSize;i++){
				fileScrittura.println(righe[i]!=null?righe[i]:"");
			}
		
		}catch(IOException e){
			System.out.println("Errore");
		}
		
	
	}
	public static String [] resize(String [] arr, int newSize)
	{
		String [] nArr= new String[newSize];
		System.arraycopy(arr,0,nArr,0,arr.length);
		return nArr;
	
	}




}
