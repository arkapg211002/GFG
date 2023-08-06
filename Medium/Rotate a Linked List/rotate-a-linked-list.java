//{ Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
      
        Node first=null;
        Node shift=null;
        Node p=head;
        int c=0;
        while(p!=null)
        {
            c+=1;
            p=p.next;
        }
        if(c==k) return head;
        p=head;
        while(k>0)
        {
            shift=add(shift,p.data);
            p=p.next;
            k-=1;
        }
        while(p!=null)
        {
            first=add(first,p.data);
            p=p.next;
        }
        Node temp=first;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=shift;
        return first;
        
    }
    public Node add(Node head,int d)
    {
        Node temp=new Node(d);
        if(head==null)
        {
            temp.next=head;
            head=temp;
            return head;
        }
        Node p=head;
        while(p.next!=null)
        {
            p=p.next;
        }
        temp.next=p.next;
        p.next=temp;
        return head;
    }
}
