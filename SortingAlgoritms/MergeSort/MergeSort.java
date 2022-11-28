
/**
	Questa classe ordina un vettore di interi (int) da una posizione Start(incluso) ad una Posizione 	End(Escluso)
	@author Alberto Barbato
	@version 1.0
*/
public class MergeSort 
{
	/*public static void main(String [] args) throws Exception
	{
	 int [] vett = {1,4,3,7,2,34,23,1,4,6,787,45,23,4,4534,564,343543,354,45};
	 
	 sort(vett,0,vett.length);
	 
	 for(int i=0;i<vett.length;i++){
	 	System.out.println(vett[i]);
	 }
				
		
	}*/
	/**
		Metodo da chiamare per ordinare il vettore 
		@param vett Vetore di int da ordinare
		@param start posizione iniziale inclusa
		@param end posizone finale esclusa
		@throws Exception Start oppure End non valido
	*/	
	public static void sort(int [] vett, int start, int end) throws Exception
	{
		if(start>=vett.length || end>vett.length ||start>end||start<0)
		{
			throw new Exception("Start or End Not Valid");
		}
		if(end-start<=1)return;
		
		
			
		sort(vett,start,(end+start)/2);
		sort(vett,(end+start)/2,end);
		merge(vett,start,(end+start)/2,end);
	} 
	
	private static void merge(int [] vett,int start,int mid, int end)
	{
		int [] sorted = new int[end-start];
		int indexStart=start;
		int indexMid=mid;
		for(int i=0;i<sorted.length;i++)
		{
			if(indexStart<mid && indexMid<end)
			{
				if(vett[indexStart]<vett[indexMid])
				{
					sorted[i]=vett[indexStart];
					indexStart++;
				}else
				{
					sorted[i]=vett[indexMid];
					indexMid++;
				}
			}else if(indexStart<mid)
			{
				sorted[i]=vett[indexStart];
				indexStart++;	
			}else
			{
				
				sorted[i]=vett[indexMid];
				indexMid++;
			}
		}
		
		for(int i=0;i<end-start;i++)
		{
			//System.out.print(sorted[i]+" ");
			
			vett[i+start]=sorted[i];
		}
		//System.out.print("\n\n");
		
	}
	
}
