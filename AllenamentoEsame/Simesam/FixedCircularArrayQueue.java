public class FixedCircularArrayQueue extends FixedArrayQueue 
{
    private int size;
    public FixedCircularArrayQueue()
    {
        super();
        size=0;
    }
    public FixedCircularArrayQueue(int size)
    {
        super(size+1);
        size=0;
    }
    public int size()
    {
        return size;
    }
    protected int increment(int x)
    {
        return (x+1)%container.length;
    }
    public void enqueue(Object obj)
    {
        if(increment(back)==front)
        {
            throw new FullQueueException();
        }
        size++;
        container[back]=obj;
        back=increment(back);
    }
    public Object dequeue()
    {
        Object obj =getFront();
        size--;
        front =increment(front);
        return obj;
    }
    public Object [] toArray()
    {
        Object [] out = new Object[size()];
        if(front<back){
            System.arraycopy(container,front,out,0,size());
        }else
        {
            System.arraycopy(container,front,out,0,container.length-front);
            System.arraycopy(container,0,out,container.length-front,back);
        }

        return out;
    }
}
class FullQueueException extends RuntimeException{}
class EmptyQueueException extends RuntimeException{}