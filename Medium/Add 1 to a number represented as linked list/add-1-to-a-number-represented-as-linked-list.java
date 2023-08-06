//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node p=head;
        p=reverse(p);
        Node start=null;
        int extra=1;
        while(p!=null)
        {
            int s=p.data+extra;
            extra=s/10;
            start=addnode(start,s%10);
            p=p.next;
        }
        if(extra!=0)
        {
            start=addnode(start,extra);
        }
        start=reverse(start);
        return start;
    }
    public static Node reverse(Node start)
    {
        Node prev,ptr,next;
        prev=null;
        ptr=start;
        while(ptr!=null)
        {
            next=ptr.next;
            ptr.next=prev;
            prev=ptr;
            ptr=next;
        }
        start=prev;
        return start;
    }
    public static Node addnode(Node start,int d)
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
            p=p.next;
        temp.next=p.next;
        p.next=temp;
        return start;
    }
}
