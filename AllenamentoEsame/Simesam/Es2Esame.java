import javax.naming.ldap.ExtendedRequest;

public class Es2Esame {
    
    public static void main(String [] args)
    {
        GrowingArrayStack s = new GrowingArrayStack();

        for(int i=0;i<0;i++){
            s.push((int)(10*Math.random()));
        }
        Object o;
        System.out.println(Sim.printArray(s.toArray()));
        mergeSort(s);
        System.out.println(Sim.printArray(s.toArray()));

        GrowingCircularArrayQueue q = new GrowingCircularArrayQueue();
        for(int i=0;i<15;i++){
            q.enqueue((int)(10*Math.random()));
        }
        System.out.println(Sim.printArray(q.toArray()));
        mergeSort(q);
        System.out.println(Sim.printArray(q.toArray()));
    }

    public static void mergeSort(GrowingCircularArrayQueue q)
    {
        if(q.size()<=1){return;}
        int mid= q.size()/2;
        int n= q.size();
        GrowingCircularArrayQueue left = new GrowingCircularArrayQueue();
        GrowingCircularArrayQueue right = new GrowingCircularArrayQueue();

        for(int i=0;i<mid;i++)
        {
            left.enqueue(q.dequeue());
        }
        for(int i=mid;i<n;i++)
        {
            right.enqueue(q.dequeue());
        }
        mergeSort(left);
        mergeSort(right);

        merge(q,left,right);
    }
    public static void merge(GrowingCircularArrayQueue out,GrowingCircularArrayQueue left,GrowingCircularArrayQueue right)
    {
        while(!left.isEmpty() && !right.isEmpty())
        {
            if(((Comparable)left.getFront()).compareTo((Comparable)right.getFront())<0)
            {
                out.enqueue(left.dequeue());
            }else{
                out.enqueue(right.dequeue());
            }

        }
        while(!left.isEmpty())
        {
            out.enqueue(left.dequeue());
        }
        while( !right.isEmpty())
        {
            out.enqueue(right.dequeue());
        }
    }


    public static void mergeSort(GrowingArrayStack s)
    {
        if(s.size()<=1){return;}
        int mid = s.size()/2;
        //System.out.println(s.size());
        int n=s.size();
        GrowingArrayStack left = new GrowingArrayStack();
        GrowingArrayStack right = new GrowingArrayStack();
        for(int i=0;i<mid;i++)
        {
            left.push(s.pop());
           // System.out.println(s.size());
        }
        for(int i=mid;i<n;i++)
        {
            right.push(s.pop());
            //System.out.println(s.size());
        }
        
       //System.out.println(s.size());
        mergeSort(left);
        mergeSort(right);
        merge(s,left,right);
    }
    public static void merge(GrowingArrayStack out,GrowingArrayStack left, GrowingArrayStack right)
    {
        GrowingArrayStack temp = new GrowingArrayStack();
        while(left.size()>0 && right.size()>0)
        {
            if(((Comparable)left.top()).compareTo((Comparable)right.top())<0)
            {
                temp.push(left.pop());
            }else{
                temp.push(right.pop());
            }
        }
        while(left.size()>0)
        {
            temp.push(left.pop());
        }
        while(right.size()>0)
        {
            temp.push(right.pop());
        }
        while(temp.size()>0)
        {
            out.push(temp.pop());
        }
    }
}
