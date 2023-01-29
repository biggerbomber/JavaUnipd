public class DataStructureTester {
    public static void main (String [] args)
    {
        SortedArraySortedMap f= new SortedArraySortedMap();
        //GrowingArrayStack g = new GrowingArrayStack(1);

        String s="ciao1";
        String s2="ciao2";
        String s3="ciao3";


        f.put(s,1);
        f.put(s2,4);
        f.put(s3,2);
        f.put(s3+"lol",3);
        System.out.println(ArrayUtilObject.printArray(f.sortedKeys()));
        System.out.println(f.remove(s));
        System.out.println(ArrayUtilObject.printArray(f.sortedKeys()));
        System.out.println(f.get(s2));
        System.out.println(ArrayUtilObject.printArray(f.sortedKeys()));
       // System.out.println(f.dequeue());
        //System.out.println(f.pop());
    }
}
