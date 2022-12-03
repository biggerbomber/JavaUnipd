

public class QuickSort
{
	/*public static void main(String [] args) throws Exception
	{
		int [] vett = {1,4,3,7,2,34,23,1,4,6,787,45,23,4,4534,564,343543,354,45};
	 
	 	sort(vett,0,vett.length);
	 
		for(int i=0;i<vett.length;i++)
		{
	 		System.out.println(vett[i]);
		}
	}/* */
	public static void sort(int [] v)
	{
		sort(v, 0, v.length);

	}
	/**
		Metodo da chiamare per ordinare il vettore 
		@param v Vetore di int da ordinare
		@param vSize Dimenzione dinamica vettore

	*/
	public static void sort(int [] v, int vSize)
	{
		if(v.length<vSize){return;}
		sort(v,0,vSize);
	}
	
	public static void sort(int [] vett,int start,int end)
	{
		System.out.println(start+" "+end);
		if(start>vett.length || end>vett.length ||start<0)
		{
			throw new IllegalArgumentException("Start or End Not Valid");
		}
		if(start>end)return;
		if(Math.abs(end-start)<=1)return;
		
		int pivot = pivoting(vett,start,end);
		sort(vett, start,pivot-1);
		sort(vett,pivot+1,end);
	}
	
	private static int pivoting(int [] vett, int start,int end)
	{
		System.out.println("PRIMA: Start= "+start+" End= "+end);
		for(int i=start;i<end;i++)
		{
			System.out.print(vett[i]+" ");
		}
		int pivot=start;
		for(int i=1+start;i<end;i++)
		{
			if(vett[i]<vett[pivot])
			{
				int temp=vett[i];
				vett[i]=vett[pivot+1];
				vett[pivot+1]=temp;
				
				temp=vett[pivot];
				vett[pivot]=vett[pivot+1];
				vett[pivot+1]=temp;
				
				pivot++;
			}
		}
		System.out.println("\nDOPO:");
		for(int i=start;i<end;i++)
		{
			System.out.print(vett[i]+" ");
		}
		System.out.println("\n\n\n");
		return pivot;
			
		
	}
	
}
