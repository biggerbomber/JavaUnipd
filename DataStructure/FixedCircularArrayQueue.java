public class FixedCircularArrayQueue extends FixedArrayQueue 
{
    public FixedCircularArrayQueue()
    {
        super();
    }
    public FixedCircularArrayQueue(int size)
    {
        super(size+1);
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
        container[back]=obj;
        back=increment(back);
    }
    public Object dequeue()
    {
        Object obj =getFront();
        front =increment(front);
        return obj;
    }
}
