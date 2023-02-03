public class GrowingArrayQueue extends FixedArrayQueue
{
    public GrowingArrayQueue(int size)
    {
        super(size);
    }
    public void enqueue(Object obj) 
    {
        if(back==container.length)
        {
            container=ArrayUtilObject.resize(container,container.length*2);
        }
        super.enqueue(obj);
    }   
}
