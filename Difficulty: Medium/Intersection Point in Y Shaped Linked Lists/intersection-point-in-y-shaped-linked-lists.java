//{ Driver Code Starts
import java.io.*;


// } Driver Code Ends
/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/
class Solution {
    Node intersectPoint(Node headA, Node headB) {

    Node A = headA;
    Node B = headB;

    while(A != B)
    {
        A = (A == null) ? headB : A.next;
        B = (B == null) ? headA : B.next;
    }

    return A;
    }
}



//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String input1 = br.readLine().trim();
            String input2 = br.readLine().trim();
            String input3 = br.readLine().trim();

            Node head1 = buildLinkedList(input1);
            Node head2 = buildLinkedList(input2);
            Node head3 = buildLinkedList(input3);

            // Connect the common linked list to both head1 and head2
            if (head1 != null) {
                Node tail1 = head1;
                while (tail1.next != null) {
                    tail1 = tail1.next;
                }
                tail1.next = head3;
            }

            if (head2 != null) {
                Node tail2 = head2;
                while (tail2.next != null) {
                    tail2 = tail2.next;
                }
                tail2.next = head3;
            }

            Solution ob = new Solution();
            Node intersection = ob.intersectPoint(head1, head2);
            if (intersection != null) {
                System.out.println(intersection.data);
            } else {
                System.out.println(-1); // Print -1 if no intersection
            }
        }
    }

    public static Node buildLinkedList(String input) {
        if (input.isEmpty()) {
            return null;
        }

        String[] values = input.split(" ");
        Node head = null, tail = null;

        for (String value : values) {
            int data = Integer.parseInt(value.trim());
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }
}

// } Driver Code Ends