import java.util.Scanner;

public class ArrayUtil
{

	public static int [] resize(int[] vett, int newSize)
	{
		int [] newVett= new int[newSize];
		
		for(int i=0;i<vett.length && i<newSize;i++)
		{
			newVett[i]=vett[i];
		}
		
		return newVett;
	}
	public static int[] randomIntArray(int length, int n)
	{
		int [] rand= new int[length];
		for(int i=0;i<length;i++)
		{
			rand[i]=(int)(n*Math.random());
		}
		return rand;
		
	}
	public static String printArray(int[] v)
	{
		if(v==null)return "null";
		return printArray(v,v.length);
	}
	public static String printArray(int[] v, int vSize)
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
	
	public static void remove(int[] v, int vSize, int index)
	{
		v[index]=v[vSize-1];
	
	}
	public static void removeSorted(int[] v, int vSize, int index)
	{
		
		for(int i=index+1;i<vSize;i++)
		{
			v[i-1]=v[i];
		}
	}
	public static int [] insert(int[] v, int vSize, int index, int value)
	{
		if(v.length==vSize)
		{
			
			v=resize(v,vSize*2);
			
		}
		
		for(int i=vSize;i>index;i--)
		{	
			//System.out.println(i);
			v[i]=v[i-1];
		}
		v[index]=value;
		return v;
	
	}
	public static int findMin(int[] v, int vSize)
	{
		if(vSize==0) {return Integer.MIN_VALUE;}
		int min= v[0];
		for(int i=1;i<vSize;i++)
		{
			if(v[i]<min)
			{
				min=v[i];
			}
		}
		return min;
	}
	public static int findMax(int[] v, int vSize)
	{
		if(vSize==0) {return Integer.MAX_VALUE;}
		int max= v[0];
		for(int i=1;i<vSize;i++)
		{
			if(v[i]>max)
			{
				max=v[i];
			}
		}
		return max;
	}
	public static int find(int[] v, int vSize, int target)
	{
		for(int i=0;i<vSize;i++)
		{
			if(v[i]==target)
			{
				return i;
			}
		}
		return -1;
	
	}
	
	
	
	
	
	
	
	
	
	
}
