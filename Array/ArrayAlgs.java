
public class ArrayAlgs
{
	
	public static void selectionsort(int[] v)
	{
		selectionsort(v,v.length);
		return;
	}
	
	public static void insertsort(int[] v)
	{
		insertsort(v,v.length);
		return;
	}
	public static void selectionsort(int [] vett,int vSize)
	{
		if(vSize==0 || vSize==1 || vett==null)
		{
			return;
		}
		
		for(int i=0;i<vSize;i++)
		{
			int min=vett[i];
			int indexMin=i;
			for(int j=i+1;j<vSize;j++)
			{
				if(vett[j]<vett[indexMin])
				{
					min=vett[j];
					indexMin=j;
				
				}
				
			}
			int temp=vett[indexMin];
			vett[indexMin]=vett[i];
			vett[i]=temp;	
		}
	}
	public static void mergesort(int [] vett,int vSize)
	{	
		if(vSize>vett.length) return;
		int [] newVett= new int[vSize];
		System.arraycopy(vett,0,newVett,0,vSize);
		mergesort(newVett);
	}
	public static void mergesort(int [] vett)
	{
		if(vett==null || vett.length<2)
		{
			return;
		}
		
		int mid=vett.length/2;
		
		int [] vettSx= new int[mid];
		int [] vettDx= new int[vett.length-mid];

		System.arraycopy(vett,0,vettSx,0,mid);
		System.arraycopy(vett,mid,vettDx,0,vett.length-mid);
		
		mergesort(vettSx);
		mergesort(vettDx);
		
		merge(vett,vettSx,vettDx);
			
	}
	private static void merge(int [] output, int [] arr1, int [] arr2)
	{
		int index1=0;
		int index2=0;
		for(int i=0;i<output.length;i++)
		{
			if(index1<arr1.length && index2<arr2.length)
			{
				if(arr1[index1]<arr2[index2])
				{
					output[i]=arr1[index1++];			
				}else
				{
					output[i]=arr2[index2++];
				}
			}else if(index1<arr1.length)
			{
				output[i]=arr1[index1++];
			}else
			{
				output[i]=arr2[index2++];	
			}
	
			
		}
		
	
	}
		
		
	public static void insertsort(int [] vett, int vSize)
	{
		if(vSize==0 || vSize==1 || vett==null)
		{
			return;
		}
		
		for(int i=1;i<vSize;i++)
		{
			int j=i-1;
			int saveI=vett[i];
			while(j>=0 && vett[j]>saveI)
			{
				vett[j+1]=vett[j];
				j--;
			}
			vett[j+1]=saveI;
		}
		
	}
	
	
	
	
	
}
