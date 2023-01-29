

public class SortedArraySortedMap implements SortedMap {

    public static final int INITAL_SIZE=2;
    private int vSize;
    Pair [] container;

    private class Pair{

        private Comparable key;
        private Object value;
        public Pair(Comparable k,Object v){
            key=k;
            value=v;
        }
        public Comparable getKey(){return key;}
        public Object getValue(){return value;}
        public void setKey(Comparable k){key=k;}
        public void setValue(Object v){value=v;}
    }
    public SortedArraySortedMap()
    {
        makeEmpty();
    }
    public void makeEmpty()
    {
        vSize=0;
        container= new Pair[INITAL_SIZE];
    }   
    private int binSearch(Comparable key, int start, int end)
    {   
        if(start<=end){
            int mid = (start+end)/2;
            if(container[mid].getKey().compareTo(key)==0)
            {
                return mid;
            }else if(container[mid].getKey().compareTo(key)<0)
            {

                return binSearch(key,mid+1,end);
            }else if(container[mid].getKey().compareTo(key)>0)
            {

                return binSearch(key,start,mid-1);
            }
        }
        return -1;

    }
    public Object get(Object key)
    {
        if(key==null || !(key instanceof Comparable))
        {
            throw new IllegalArgumentException();
        }
        int index=binSearch((Comparable)key,0,vSize-1);
        if(index>=0)
        {
            return container[index].getValue();
        }
        return null;
    }
    public Object remove(Object key)
    {   
        if(key==null || !(key instanceof Comparable))
        {
            throw new IllegalArgumentException();
        }
        
        int index = binSearch((Comparable)key, 0, vSize-1);
       
        if(index<0){return null;}
        Pair out= container[index];
        while(index<vSize-1){
            container[index]=container[index+1];
            index++;
        }
        vSize--;
        return out.getValue();
    }
    public Object put(Object key, Object value)
    {
        if(key==null || !(key instanceof Comparable))
        {
            throw new IllegalArgumentException();
        }
        int indexOld = binSearch((Comparable)key, 0, vSize-1);
        if(indexOld!=-1){
            Object out =container[indexOld].getValue();
            container[indexOld].setValue(value);
            return out;
        }else{
            Comparable cKey= (Comparable)key;
            if(vSize==container.length){
                container= resize(container, vSize*2);
            }
            int i=vSize-1;
            while(i>0 && container[i].getKey().compareTo(cKey)>0)
            {
                container[i+1]=container[i];
                i--;
            }
            container[i+1]=new Pair(cKey,value);
            vSize++;
            return null;
        }

    }
    private Pair [] resize(Pair [] arr, int newSize)
    {
        Pair[] nArr= new Pair[newSize];
        System.arraycopy(arr,0,nArr,0,arr.length);
        return nArr;
    }
    public Comparable [] sortedKeys()
    {
        Comparable [] out = new Comparable[vSize];
        for(int i=0;i<vSize;i++)
        {
            out[i]=container[i].getKey();
        }
        return out;
    }
    public Object [] keys()
    {
        return sortedKeys();
    }
    public boolean isEmpty()
    {
        return (vSize==0);
    }
}
