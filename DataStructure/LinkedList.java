import java.util.*;

public class LinkedList implements Container 
{   
    private ListNode head;
    private ListNode tail;
    
    public LinkedList()
    {
        makeEmpty();
    }
    public void makeEmpty()
    {
        head=tail=new ListNode();
    }
    public boolean isEmpty()
    {
        return head==tail;
    }
    public Object getFirst()
    {
        if(isEmpty())
        {
            throw new EmptyLinkedListException();
        }
        return head.getNext().getElement();
    }
    public Object getLast()
    {   
        if(isEmpty())
        {
            throw new EmptyLinkedListException();
        }
        return tail.getElement();
    }
    public void addFirst(Object x)
    {
        ListNode temp=new ListNode(null,head);
        head.setElement(x);
        head=temp;
    }
    public void addLast(Object x)
    {
        ListNode temp= new ListNode(x,null);
        tail.setNext(temp);
        tail=temp;
    }
    public Object removeFirst()
    {
        Object x= getFirst();
        head=head.getNext();   
        head.setElement(null);
        return x;
    }
    public Object removeLast()
    {
        Object x=getLast();
        ListNode temp=head;
        while(temp.getNext()!=tail)
        {
            temp=temp.getNext();
        }
        tail=temp;
        tail.setNext(null);
        return x;
    }
    public ListIterator getIterator()
    {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements ListIterator
    {
        private ListNode previous;
        private ListNode current;
        public LinkedListIterator()
        {
            previous=null;
            current=head;
        }
        public boolean hasNext()
        {
            return current.getNext()!=null;   
        }
        public Object next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            previous=current;
            current=current.getNext();
            return current.getElement();
        }
        public void add(Object x)
        {
            ListNode temp= new ListNode(x,current.getNext());
            current.setNext(temp);
            previous=current;
            current=temp;
            if(current.getNext()==null)
            {
                tail=current;
            }
        }
        public Object remove()
        {
            if(previous==null)
            {
                throw new IllegalStateException();
            }

            previous.setNext(current.getNext());
            Object x=current.getElement();
            current=previous;
            previous=null;
            
            if(current.getNext()==null)
            {
                tail=current;
            }
            return x;
        }
    }
    private class ListNode
    {
        private Object value;
        private ListNode next;

        public ListNode()
        {
            value=null;
            next=null;
        }
        public ListNode(Object value,ListNode next)
        {
            this.value=value;
            this.next=next;
        }
        public Object getElement()
        {
            return value;
        }
        public ListNode getNext()
        {
            return next;
        }
        public void setElement(Object x)
        {
            value=x;
        }
        public void setNext(ListNode n)
        {
            next=n;
        }
    }

}

class EmptyLinkedListException extends RuntimeException{}