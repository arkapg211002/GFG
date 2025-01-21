//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends




/*node class of the linked list
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

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) {
            return head; // No need to reverse if the list is empty or k is 1.
        }

        // Count the total number of nodes in the linked list
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Dummy node to handle the head of the list
        Node dummy = new Node(0);
        dummy.next = head;

        Node prevGroupEnd = dummy; // Tracks the end of the previous group
        Node curr = head;          // Start of the current group

        while (count >= k) {
            Node groupStart = curr;  // Start of the current group
            Node prev = null;        // To reverse the group

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect the reversed group with the previous group
            prevGroupEnd.next = prev;
            groupStart.next = curr;

            // Update pointers
            prevGroupEnd = groupStart;
            count -= k;
        }

        // Reverse the remaining nodes if they exist
        if (count > 0) {
            Node remainingStart = curr;
            Node prev = null;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupEnd.next = prev;
        }

        return dummy.next;
    }
}
