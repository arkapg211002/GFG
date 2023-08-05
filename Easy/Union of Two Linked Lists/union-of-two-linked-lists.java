//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    HashSet<Integer>h=new HashSet<>();
	    Node p=head1;
	    while(p!=null)
	    {
	        h.add(p.data);
	        p=p.next;
	    }
	    p=head2;
	    while(p!=null)
	    {
	        h.add(p.data);
	        p=p.next;
	    }
	    List<Integer>l=new ArrayList<Integer>(h);
	    Collections.sort(l);
	    Node start=null;
	    for(int i=0;i<l.size();i++)
	    {
	        start=insert(start,l.get(i));
	    }
	    return start;
	}
	public static Node insert(Node start,int d)
	{
	    Node temp=new Node(d);
	    if(start==null)
	    {
	        temp.next=start;
	        start=temp;
	        return start;
	    }
	    Node p=start;
	    while(p.next!=null)
	    {
	        p=p.next;
	    }
	    temp.next=p.next;
	    p.next=temp;
	    return start;
	}
}