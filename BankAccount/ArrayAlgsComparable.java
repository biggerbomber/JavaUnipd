
public class ArrayAlgsComparable
{
	
	public static void selectionsort(Comparable[] v)
	{
		selectionsort(v,v.length);
		return;
	}
	
	public static void insertsort(Comparable[] v)
	{
		insertsort(v,v.length);
		return;
	}
	public static void selectionsort(Comparable [] vett,int vSize)
	{
		if(vSize==0 || vSize==1 || vett==null)
		{
			return;
		}
		
		for(int i=0;i<vSize;i++)
		{
			Object min=vett[i];
			int indexMin=i;
			for(int j=i+1;j<vSize;j++)
			{
				if(vett[j].compareTo(vett[indexMin])>0)
				{
					min=vett[j];
					indexMin=j;
				
				}
				
			}
			Comparable temp=vett[indexMin];
			vett[indexMin]=vett[i];
			vett[i]=temp;	
		}
	}
	public static void mergesort(Comparable [] vett,int vSize)
	{	
		if(vSize>vett.length) return;
		Comparable [] newVett= new Comparable[vSize];
		System.arraycopy(vett,0,newVett,0,vSize);
		mergesort(newVett);
	}
	public static void mergesort(Comparable [] vett)
	{
		if(vett==null || vett.length<2)
		{
			return;
		}
		
		int mid=vett.length/2;
		
		Comparable [] vettSx= new Comparable[mid];
		Comparable [] vettDx= new Comparable[vett.length-mid];

		System.arraycopy(vett,0,vettSx,0,mid);
		System.arraycopy(vett,mid,vettDx,0,vett.length-mid);
		
		mergesort(vettSx);
		mergesort(vettDx);
		
		merge(vett,vettSx,vettDx);
			
	}
	private static void merge(Comparable [] output, Comparable [] arr1, Comparable [] arr2)
	{
		int index1=0;
		int index2=0;
		for(int i=0;i<output.length;i++)
		{
			if(index1<arr1.length && index2<arr2.length)
			{
				if(arr1[index1].compareTo(arr2[index2])<0)
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
		
		
	public static void insertsort(Comparable [] vett, int vSize)
	{
		if(vSize==0 || vSize==1 || vett==null)
		{
			return;
		}
		
		for(int i=1;i<vSize;i++)
		{
			int j=i-1;
			Comparable saveI=vett[i];
			while(j>=0 && vett[j].compareTo(saveI)>0)
			{
				vett[j+1]=vett[j];
				j--;
			}
			vett[j+1]=saveI;
		}
		
	}
	public static Object findMin(Comparable[] v, int vSize)
	{
		if(vSize==0) {return null;}
		Comparable min= v[0];
		for(int i=1;i<vSize;i++)
		{
			if(v[i].compareTo(min)<0)
			{
				min=v[i];
			}
		}
		return min;
	}
	public static Comparable findMax(Comparable[] v, int vSize)
	{
		if(vSize==0) {return Integer.MAX_VALUE;}
		Comparable max= v[0];
		for(int i=1;i<vSize;i++)
		{
			if(v[i].compareTo(max)>0)
			{
				max=v[i];
			}
		}
		return max;
	}	
	
}
