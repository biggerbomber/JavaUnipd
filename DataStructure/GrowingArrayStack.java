public class GrowingArrayStack extends FixedArrayStack
{
    public GrowingArrayStack(int Size)
    {
        super(Size);
    }
    public void push(Object obj)
    {
        if(top==container.length)
        {
            container=ArrayUtilObject.resize(container, container.length*2);
        }
        super.push(obj);
    }   
}
