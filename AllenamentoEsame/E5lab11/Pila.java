


public class Pila
{
	public static final int INITIAL_SIZE=3;
	private Object [] container;
	private int vSize;
	
	public Pila(){
		makeEmpty();
	}
	public void makeEmpty(){
		container = new Object[INITIAL_SIZE];
		vSize=0;
	}
	
	public Object top()
	{
		if(vSize==0){
			throw new EmptyStackException();
		}
		return container[vSize-1];
	}
	public Object pop(){
		Object out = top();
		vSize--;
		return out;
		
	}
	public void push(Object t){
	
		if(vSize>=container.length){
			container = resize(container,vSize*2);
		}
		
		container[vSize++]=t;
	}
	public static Object [] resize(Object [] arr, int newSize){
	
		Object [] nArr= new Object[newSize];
		System.arraycopy(arr,0,nArr,0,arr.length);
		return nArr;
	}
	public boolean isEmpty(){
		return vSize==0;
	}

}
class EmptyStackException extends RuntimeException{}





