public class DataStructureTester {
    public static void main (String [] args)
    {
        LinkedList f= new LinkedList();
        //GrowingArrayStack g = new GrowingArrayStack(1);

        String s="ciao1";
        String s2="ciao2";
        String s3="ciao3";


        f.addLast(s);
        f.addLast(s2);
        f.addLast(s3);
        f.addLast(s3+"kuci");
        
        ListIterator it=f.getIterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        it.remove();
        System.out.println(f.removeFirst());
        System.out.println(f.removeLast());
        System.out.println(f.getFirst());

       // System.out.println(f.dequeue());
        //System.out.println(f.pop());
    }
}
