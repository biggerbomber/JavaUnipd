import java.util.Scanner;

public class SortingTester
{
	public static void main (String [] args)
	{
		int n=0;
		if(args.length!=1)
		{
			System.out.println("devi inserire un numero please");
		}
		try
		{
			n=Integer.parseInt(args[0]);
			if(n<=0){
				throw new NumberFormatException();
			}
			
		}catch(NumberFormatException e)
		{
			System.out.println("devi inserire un numero intero maggiore di 1 please");
			System.exit(1);
		}
		if(n>=20)
		{
			int []vett1=generaCasuali(n,1,100);
			int []vett2=copiaArray(vett1);
			int []vett3=copiaArray(vett1);
			//System.out.println(ArrayUtil.printArray(vett1)+" <---- controllo");
			long start,end;
			start=System.currentTimeMillis();
			ArrayAlgs.selectionsort(vett1);
			end=System.currentTimeMillis();
			System.out.println("selection: " +(end-start));
			//System.out.println(ArrayUtil.printArray(vett1));
			start=System.currentTimeMillis();
			ArrayAlgs.mergesort(vett2);
			end=System.currentTimeMillis();
			System.out.println("merge: " +(end-start));
			//System.out.println(ArrayUtil.printArray(vett2));
			start=System.currentTimeMillis();
			ArrayAlgs.insertsort(vett3);
			end=System.currentTimeMillis();
			System.out.println("insert: " +(end-start));
			//System.out.println(ArrayUtil.printArray(vett3));
			
			
		}
		
		
		
		
	}
	private static int[] copiaArray(int vett[])
	{
		if(vett==null)
		{
			return null;
		}
		
		int [] newVett= new int[vett.length];
		System.arraycopy(vett,0,newVett,0,vett.length);
		return newVett;
	
	}
	private static int [] generaCasuali(int n,int min, int max)
	{
		

		if(min>max)
		{
			throw new IllegalArgumentException();
		}
		int [] vett=new int[n];
		for(int i=0;i<vett.length;i++)
		{
			vett[i]=(int)(min+(max-min+1)*Math.random());
		}
		return vett;

	}
}
