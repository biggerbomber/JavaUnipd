public class MergeSortRicProva {
    
    public static void main(String [] args){

        String [] vett  = {" ","dd","ciao","sono","barb"};

        mergeSort(vett);
        for(int i=0;i<vett.length;i++){
            System.out.print(vett[i]+" ");
        }
    }

    public static void mergeSort(Comparable [] arr)
    {
        if(arr==null){throw new IllegalArgumentException();}
        if(arr.length<2){
            return ;
        }
        int mid=arr.length/2;
        Comparable [] left = new Comparable[mid];
        Comparable [] right = new Comparable[arr.length-mid];

        System.arraycopy(arr,0,left,0,mid);
        System.arraycopy(arr,mid,right,0,arr.length-mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr,left,right);
    }
    public static void merge(Comparable [] out,Comparable [] left, Comparable [] right)
    {
        int outIndex=0;
        int leftIndex=0;
        int rightIndex=0;

        while(leftIndex<left.length && rightIndex<right.length){
            if(left[leftIndex].compareTo(right[rightIndex])<0)
            {
                out[outIndex++]=left[leftIndex++];
            }else
            {
                out[outIndex++]=right[rightIndex++];
            }
        }

        while(rightIndex<right.length)
        {
            out[outIndex++]=right[rightIndex++];
        }
        while(leftIndex<left.length)
        {
            out[outIndex++]=left[leftIndex++];
        }
    }

}
