public class DataStructureTester {
    public static void main (String [] args)
    {
        GrowingCircularArrayQueue f= new GrowingCircularArrayQueue(3);
        //GrowingArrayStack g = new GrowingArrayStack(1);

        String s="ciao1";
        String s2="ciao2";
        String s3="ciao3";


        f.enqueue(s);
        f.enqueue(s2);
        f.enqueue(s3);
     
        System.out.println(f.dequeue());
        System.out.println(f.dequeue());
        
       // System.out.println(f.dequeue());
        //System.out.println(f.pop());
    }
}
