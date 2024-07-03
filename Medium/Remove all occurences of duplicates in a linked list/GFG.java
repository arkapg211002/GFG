// https://www.geeksforgeeks.org/problems/remove-all-occurences-of-duplicates-in-a-linked-list/1

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

class GFG {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            GFG llist = new GFG();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < N; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            Solution ob = new Solution();
            head = ob.removeAllDuplicates(llist.head);
            llist.printList(head);

            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public Node removeAllDuplicates(Node head) {
      
        if(head.next==null)
        return head;
        
        Node dummy=new Node(-1);
        Node ans=dummy;
        
        Node temp=head;
        while(temp!=null)
        {
            if(temp.next!=null)
            {
                if(temp.data!=temp.next.data)
                {
                    ans.next=temp;
                    ans=ans.next;
                    temp=temp.next;
                }
                else
                {
                    int k=temp.data;
                    temp=temp.next;
                    
                    while(temp!=null && temp.data==k)
                    temp=temp.next;
                }
            }
            else
            {
                ans.next=temp;
                ans=ans.next;
                temp=temp.next;
            }
            
        }
        ans.next=null;
        return dummy.next;
    }
}

