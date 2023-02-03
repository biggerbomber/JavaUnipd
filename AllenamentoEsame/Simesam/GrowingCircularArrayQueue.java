public class GrowingCircularArrayQueue extends FixedCircularArrayQueue 
{
    public GrowingCircularArrayQueue(int size)
    {
        super(size);
    }
    public GrowingCircularArrayQueue()
    {
        super();
    }
    public void enqueue(Object obj)
    {
        if(increment(back)==front)
        {
            container=ArrayUtilObject.resize(container, container.length*2);
            if(back<front)
            {
                System.arraycopy(container, 0, container, container.length/2, back);
                back+=container.length/2;
            }       
        }
        super.enqueue(obj);
    }
}
