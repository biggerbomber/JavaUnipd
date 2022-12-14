public class SlowFixedArrayQueue implements Queue
{    
    private Object [] container;
    private int back;

    public SlowFixedArrayQueue()
    {
        container= new Object[100];
        makeEmpty();
    }
    public SlowFixedArrayQueue(int size)
    {
        container= new Object[size];
        makeEmpty();
    }

    public void makeEmpty()
    {
        back=0;
    }

    public boolean isEmpty()
    {
        return (back==0);
    } 

    public void enqueue(Object obj)
    {
        if(back==container.length)
        {
            throw new FullQueueException();
        }
        container[back++]=obj;
    }
    
    public Object getFront()
    {
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        return container[0];
    }

    public Object dequeue()
    {
        Object obj=getFront();
        for(int i=1;i<back;i++)
        {
            container[i-1]=container[i];
        }
        back--;
        return obj;
    }
}

class FullQueueException extends RuntimeException{}
class EmptyQueueException extends RuntimeException{}