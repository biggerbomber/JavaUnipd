public class ArrayMap implements Map
{
    private Pair [] container;
    private int vSize;

    private class Pair
    {
        private Object key;
        private Object value;
        public Pair()
        {
            key=null;
            value=null;
        }
        public Pair(Object k, Object v)
        {
            setKey(k);
            setValue(v);
        }
        public Object getKey(){return key;}
        public Object getValue(){return value;}

        public void setKey(Object newKey){key=newKey;}
        public void setValue(Object newValue){key=newValue;}
  
    }
    public ArrayMap()
    {
        container= new Pair[100];
        makeEmpty();
    }
    public ArrayMap(int size)
    {
        container = new Pair[size];
        makeEmpty();
    }
    public void makeEmpty()
    {
        vSize=0;
    }
    public boolean isEmpty()
    {
        return (vSize==0);
    }
    public Object get(Object key)
    {
        for(int i=0;i<vSize;i++)
        {
            if(container[i].getKey().equals(key))
            {
                return container[i].getValue();
            }
        }
        return null;
    }
    public Object remove(Object key)
    {
        for(int i=0;i<vSize;i++)
        {
            if(container[i].getKey().equals(key))
            {
                Object obj= container[i].getValue();
                container[i]=container[vSize-1];
                vSize--;
                return obj;
            } 
        }
        return null;
    }
    public Object put(Object key, Object value)
    {
        if(key==null ||value == null)
        {
            throw new IllegalArgumentException();
        }
        Object old = remove(key);
        if(vSize==container.length)
        {
            container=(Pair[])ArrayUtilObject.resize(container, container.length*2);
        }
        container[vSize++]= new Pair(key,value);
        return old;
    }
    public Object [] keys()
    {
        Object [] out = new Object[vSize];
        for(int i=0;i<vSize;i++)
        {
            out[i]=container[i].getKey();
        }
        return out;
    }
}
