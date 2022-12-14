
public class ArrayUtilObject
{	
	public static int [] generaIntCasuali(int n,int min, int max)
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
	public static Object[] copiaArray(Object vett[])
	{
		if(vett==null)
		{
			return null;
		}
		return copiaArray(vett,vett.length);
	}
	public static Object[] copiaArray(Object vett[], int vSize)
	{
		if(vett==null)
		{
			return null;
		}
		
		Object [] newVett= new Object[vSize];
		System.arraycopy(vett,0,newVett,0,vSize);
		return newVett;
	
	}
	public static Object [] resize(Object[] vett, int newSize)
	{
		Object [] newVett= new Object[newSize];
		
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
	
	public static void remove(Object[] v, int vSize, int index)
	{
		v[index]=v[vSize-1];
	
	}
	public static void removeSorted(Object[] v, int vSize, int index)
	{
		
		for(int i=index+1;i<vSize;i++)
		{
			v[i-1]=v[i];
		}
	}
	public static Object [] insert(Object[] v, int vSize, int index, int value)
	{
		if(v.length==vSize)
		{
			throw new ArrayOutOfSpaceException();	
		}
		
		for(int i=vSize;i>index;i--)
		{	
			//System.out.println(i);
			v[i]=v[i-1];
		}
		v[index]=value;
		return v;
	
	}
	
	public static int find(Object[] v, int vSize, Object target)
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
