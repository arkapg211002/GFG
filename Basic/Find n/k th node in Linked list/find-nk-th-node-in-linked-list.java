//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class LinkedList
{
    static Node head;
    
     public static void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
    
     public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-- > 0)
		 {
		     int n = sc.nextInt();
		     int a1 = sc.nextInt();
		     Node head = new Node(a1);
		     addToTheLast(head);
		     for(int i = 1; i < n; i++)
		     {
		         int a = sc.nextInt(); 
				 addToTheLast(new Node(a));
			 }
			 int k = sc.nextInt();
			GfG gfg = new GfG();
			System.out.println(gfg.nknode(head, k));
		     }
		 }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class GfG
{
    public static int nknode(Node head, int k)
    {
       // add your code here
       int n=0;
       Node p=head;
       while(p!=null)
       {
           n+=1;
           p=p.next;
       }
       int ind=(int)Math.ceil(n*1.0/k);
       p=head;
       for(int i=1;i<ind;i++)
            p=p.next;
       return p.data;
       
    }
}
