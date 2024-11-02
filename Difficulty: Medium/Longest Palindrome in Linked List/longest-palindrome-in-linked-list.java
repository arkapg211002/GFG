//{ Driver Code Starts
import java.io.*;
import java.lang.Math;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class PalindromeLL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().trim().split("\\s+");
            Node head = new Node(Integer.parseInt(input[0]));
            Node tail = head;
            for (int i = 1; i < input.length; i++) {
                tail.next = new Node(Integer.parseInt(input[i]));
                tail = tail.next;
            }
            Solution ob = new Solution();
            System.out.println(ob.maxPalindrome(head));
        
System.out.println("~");
}
    }

    public static Node insert(Node head, int val) {
        if (head == null) return new Node(val);
        head.next = insert(head.next, val);
        return head;
    }

    /*public static void print(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }*/
}
// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}*/


/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}*/
class Solution {
    public static int maxPalindrome(Node head) {
        // add code here.
        Node curr = head;
        int maxlength = 0;
        while(curr!=null){
            maxlength = Math.max(maxlength,expandAroundCenter(curr,curr,head));
            if(curr.next!=null){
                maxlength = Math.max(maxlength,expandAroundCenter(curr,curr.next,head));
                
            }
            curr = curr.next;
            
        }
        return maxlength;
    }
    static int expandAroundCenter(Node left, Node right,Node head){
        int length = 0;
        while(left!=null && right!=null && left.data==right.data){
            length += (left == right) ? 1 : 2;
            left = getPrevious(left,head);
            right = right.next;
            
        }
        
        return length;
    }
    static Node getPrevious(Node node, Node head){
        Node t = head;
        while(t!=null && t.next!=node){
            t=t.next;
        }
        return t;
    }
}