public class ComparableSet implements Set
{
	private Comparable [] container;
	private int vSize;
	public ComparableSet()
	{
		container = new Comparable[10];
		makeEmpty();
	}
	
	public void makeEmpty()
	{
		vSize=0;
	}
	
	public boolean isEmpty()
	{
		return (vSize==0);
	}
	
	public void add(Object x)
	{
		Comparable obj = (Comparable)x;
		if(vSize==container.length)
		{
			resize(vSize*2);
		}
		
		int i=vSize-1;
		
		while(i>=0 && container[i].compareTo(obj)>0 )
		{
			container[i+1]=container[i];
			i--;
		}
		container[i+1]=obj;
		vSize++;
		
	}
	public boolean contains(Object xi)
	{
		Comparable x =(Comparable)xi;
		int sx=0,dx=vSize-1;
		while(sx<=dx)
		{
			int mid = (sx+dx)/2;
			if(container[mid].compareTo(x)==0)
			{
				return true;
			}else if(container[mid].compareTo(x)<0)
			{
				sx=mid+1;
			}else
			{
				dx=mid-1;
			}
		}
		return false;
	}

	public void resize(int newSize)
	{
		Comparable [] newArr = new Comparable[newSize];
		for(int i=0;i<newSize && i<container.length;i++)
		{
			newArr[i]=container[i];
		}
		container=newArr;

	}
	
	public Object [] toArray()
	{
		Comparable [] newArr = new Comparable[vSize];
		for(int i=0;i<vSize && i<container.length;i++)
		{
			newArr[i]=container[i];
		}
		return newArr;	
	}
}




