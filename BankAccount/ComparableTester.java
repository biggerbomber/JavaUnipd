public class ComparableTester {
    public static void main (String [] args)
    {
        final int N=100;
        TimeDepositAccount [] arr= new TimeDepositAccount[N];

        for(int i=0;i<N;i++)
        {
            arr[i]=new TimeDepositAccount((int)(10000*Math.random()), 20, 5);
        }

        for(int i=0;i<N;i++)
        {
            System.out.println(arr[i]+"");
        }
        ArrayAlgsComparable.mergesort(arr);
        System.out.println("\n--------------------------\n");
        for(int i=0;i<N;i++)
        {
            System.out.println(arr[i]);
        }

    }
}
