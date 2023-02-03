public class Sim{
    

    public static void main(String [] args)
    {
        Integer [] v = {1,2,3,1,2,3,1,56,7,4,3,5,3,32,32,45,43,32,43,43,254363,5646};

        System.out.println(printArray(selectionSort(v)));
        System.out.println(printArray(insertionSort(v)));
        System.out.println(printArray(mergeSort(v)));
    }
    public static String printArray(Object [] v)
    {
        String out = "[";
        for(int i=0;i<v.length;i++)
        {   
            out+=" "+v[i];
        }
        out+="]";
        return out;
    }
    public static Comparable [] selectionSort(Comparable [] v)
    {
        Comparable [] out = new Comparable[v.length];
        System.arraycopy(v,0,out,0,v.length);

        for(int i=0;i<out.length;i++)
        {
            int indexMin=i;
            for(int j=i;j<out.length;j++)
            {
                if(out[j].compareTo(out[indexMin])<0){
                    indexMin=j;
                }
            }
            Comparable tmp = out[indexMin];
            out[indexMin]=out[i];
            out[i]=tmp;
        }
        return out;
    }
    public static Comparable [] insertionSort(Comparable [] v)
    {
        Comparable [] out = new Comparable[v.length];
        System.arraycopy(v,0,out,0,v.length);

        for(int i=0;i<out.length;i++)
        {
            int j=i;
            while(j>0 && out[j].compareTo(out[j-1])<0)
            {
                Comparable tmp = out[j];
                out[j]=out[j-1];
                out[j-1]=tmp;
                j--;
            }
        }

        return out;
    }
    public static Comparable [] mergeSort(Comparable [] v)
    {
        Comparable [] out = new Comparable[v.length];
        System.arraycopy(v,0,out,0,v.length);

        if(out.length==1){
            return out;
        }
        int mid = out.length/2;
        Comparable [] left = new Comparable [mid];
        Comparable [] right = new Comparable [out.length-mid];

        System.arraycopy(out,0,left,0,mid);
        System.arraycopy(out,mid,right,0,out.length-mid);

        left =mergeSort(left);
        right = mergeSort(right);

        merge(out,left,right);

        return out;
    }
    public static void merge(Comparable [] out,Comparable [] left,Comparable [] right)
    {
        int i=0;
        int indexLeft=0;
        int indexRight=0;
        while(indexLeft<left.length && indexRight<right.length)
        {
            if(left[indexLeft].compareTo(right[indexRight])<0)
            {
                out[i++]=left[indexLeft++];
            }else{
                out[i++]=right[indexRight++];
            }
        }
        while(indexLeft<left.length)
        {
            out[i++]=left[indexLeft++];
        }
        while( indexRight<right.length)
        {
            out[i++]=right[indexRight++];
        }
    }
}