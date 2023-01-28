
import java.util.Scanner;
public class StackDuplicateRemover
{
	public static void main(String [] args)
	{
		Scanner input=new Scanner(System.in);
		Stack s = new Stack();
		while(input.hasNext()){
			String num=input.next();
			if(num.equalsIgnoreCase("q"))break;
			s.push(Integer.parseInt(num));
			
			
		}
		removeDuplicates(s);

		System.out.println(s);

	}
	
	public static void removeDuplicates(Stack s)
	{
		Stack app= new Stack();
		while(!s.isEmpty()){
			Object temp=s.pop();
			int i=0;
			while(!s.isEmpty())
			{
				Object t=s.pop();
				if(!t.equals(temp)){
					app.push(t);
					i++;
				}
			}
			while(i>0){
				s.push(app.pop());
				i--;
			}
			app.push(temp);
		}
		while(!app.isEmpty()){
			s.push(app.pop());
		}
		
	}

}

class Stack
{
	
	private Object [] container;
	public static final int INITIAL_SIZE=3;
	int vSize;
	
	
	public Stack()
	{
		makeEmpty();
	}
	public boolean isEmpty()
	{
		return vSize==0;
	}
	public void makeEmpty()
	{
		vSize=0;
		container= new Object[INITIAL_SIZE];
	}
	public void push(Object obj){
		if(vSize==container.length)
		{
			container=resize(container, vSize*2);
		}
		container[vSize++]=obj;
	}
	private Object [] resize(Object [] arr, int newSize)
	{
		Object [] nArr= new Object[newSize];
		System.arraycopy(arr,0,nArr,0,arr.length);
		return nArr;
	}
	public Object pop(){
		Object out=top();
		vSize--;
		return out;
	}
	public Object top(){
		if(isEmpty()) throw new EmptyStackException();
		return container[vSize-1];
	}
	public String toString()
	{
		String out="";
		for(int i=0;i<vSize;i++){
			out+=container[i]+" ";
		}
		return out;
	}


}
class EmptyStackException extends RuntimeException{}
