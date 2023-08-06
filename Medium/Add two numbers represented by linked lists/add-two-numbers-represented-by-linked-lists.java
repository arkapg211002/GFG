//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node a=first;
        Node b=second;
        a=reverse(a);
        b=reverse(b);
        int lena=count(a);
        int lenb=count(b);
        Node start=null;
        Node extend=null;
        if(lena<lenb) 
        {
            start=a;
            extend=b;
        }
        else 
        {
            start=b;
            extend=a;
        }
        Node sum=null;
        int extra=0;
        while(start!=null)
        {
            int s=start.data+extend.data+extra;
            extra=s/10;
            sum=addnode(sum,s%10);
            extend=extend.next;
            start=start.next;
        }
        while(extend!=null)
        {
            int toadd=extend.data+extra;
            extra=toadd/10;
            sum=addnode(sum,toadd%10);
            extend=extend.next;
        }
        if(extra!=0)
        {
            sum=addnode(sum,extra);
        }
        sum=reverse(sum);
        return sum;
        
    }
    static Node reverse(Node start)
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
    static int count(Node head)
    {
        Node p=head;
        int c=0;
        while(p!=null)
        {
            c+=1;
            p=p.next;
        }
        return c;
    }
    static Node addnode(Node start,int d)
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