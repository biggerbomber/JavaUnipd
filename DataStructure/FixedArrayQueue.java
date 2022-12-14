public class FixedArrayQueue implements Queue 
{
    protected Object [] container;
    protected int front;
    protected int back;
    
    public FixedArrayQueue()
    {
        container=new Object[100];
        makeEmpty();
    }
    public FixedArrayQueue(int size)
    {
        container=new Object[size];
        makeEmpty();
    }
    public void makeEmpty()
    {
        front=0;
        back=0;
    }
    public boolean isEmpty()
    {
        return (front==back);
    }
    

    public void enqueue(Object obj)
    {
        if(back==container.length)
        {
            throw new FullQueueException();
        }
        container[back]=obj;
        back++;
    }

    public Object getFront()
    {
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        return container[front];
    }
    public Object dequeue()
    {
        Object obj =getFront();
        front++;
        return obj;
    }
}
