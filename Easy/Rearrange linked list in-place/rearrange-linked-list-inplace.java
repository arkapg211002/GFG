//{ Driver Code Starts
import java.util.*;
import java.lang.*;

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

class Rerrange
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i < n; i++)
            {
                int data = sc.nextInt();
                addToTheLast(new Node(data));
            }
            GfG gfg = new GfG();
            Node node = gfg.rearrange(head);
            printList(node);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
              temp = temp.next;
              temp.next = node;
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}


// } Driver Code Ends


/*
The structure of linked list is the following

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
    public static Node rearrange(Node root)
    {
        int c=0;
        Node p=root;
        while(p!=null)
        {
            c+=1;
            p=p.next;
        }
        int arr[]=new int[c];
        p=root;
        int i=0;
        while(p!=null)
        {
            arr[i]=p.data;
            p=p.next;
            i+=1;
        }
        Node start=null;
        for(int j=0;j<c/2;j++)
        {
            start=insert(start,arr[j]);
            start=insert(start,arr[c-j-1]);
        }
        if(c%2!=0) start=insert(start,arr[c/2]);
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

