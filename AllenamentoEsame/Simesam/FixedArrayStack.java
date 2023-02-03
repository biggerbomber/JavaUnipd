public class FixedArrayStack implements Stack
{    
    protected Object [] container;
    protected int top;

    public FixedArrayStack()
    {
        container=new Object[100];
        makeEmpty();
    }
    public FixedArrayStack(int Size)
    {
        container=new Object[Size];
        makeEmpty();
    }
    public int size()
    {
        return top;
    }
    public void makeEmpty()
    {
        top=0;
    }
    public boolean isEmpty()
    {
        return (top==0);
    }
    public void push(Object obj)
    {
        if(top==container.length)
        {
            throw new FullStackException();
        }
        container[top++]=obj;
    }
    public Object pop()
    {
        Object obj=top();
        top--;
        return obj;
    }
    public Object top()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return container[top-1];
    }
    public Object [] toArray()
    {
        Object [] out = new Object[size()];
        System.arraycopy(container,0,out,0,size());
        return out;
    }
}

class FullStackException extends RuntimeException{}
class   EmptyStackException extends RuntimeException{}