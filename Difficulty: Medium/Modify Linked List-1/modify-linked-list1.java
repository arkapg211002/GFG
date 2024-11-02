//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) { this.data = data; }
}

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node ans = ob.modifyTheList(head);
            while (ans != null) {
                out.print(ans.data + " ");
                ans = ans.next;
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java
class Solution {
    public static Node modifyTheList(Node head) {
        // code here
        Node fast = head.next;
        Node slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        
        Node secondHalf = reverseList(slow.next);
        slow.next = null;
        Node firstHalfPtr = head;
        Node ans = new Node(0);
        Node curr = ans;
        
        while (secondHalf != null) {
            curr.next = new Node(secondHalf.data - firstHalfPtr.data);
            curr = curr.next;
            secondHalf = secondHalf.next;
            firstHalfPtr = firstHalfPtr.next;
        }
        
        curr.next = reverseList(head);
        return ans.next;
    }
    
    private static Node reverseList(Node head) {
        
        Node current = head;
        Node prev = null;
        Node next = current.next;
        
        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }
        
        return prev;
    }
}