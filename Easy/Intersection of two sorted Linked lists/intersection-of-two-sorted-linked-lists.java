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
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        
        ArrayList<Integer> arr = new ArrayList<>(); 
        
        Node a = head1; 
        Node b = head2; 
        
        while(a != null && b != null)
        {
            if(a.data == b.data) 
            {
                arr.add(a.data); 
                a = a.next;  
                b = b.next;
                continue;
            }   
            else if(a.data < b.data) 
            {
                a = a.next;
            } 
            else
            {
                b = b.next;
            }
            
        } 
        
        Node dummy = new Node(0);
        Node result = dummy;

        for (int value : arr)
        {
            Node node = new Node(value);
            result.next = node;
            result = node;
        }

        return dummy.next;
    }
}