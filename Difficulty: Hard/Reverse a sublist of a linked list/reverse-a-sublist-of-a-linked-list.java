//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Main {
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input1 = br.readLine().trim().split("\\s+");
            if (input1.length < 2) {
                System.out.println(-1);
                continue;
            }
            int a = Integer.parseInt(input1[0]);
            int b = Integer.parseInt(input1[1]);

            String[] input2 = br.readLine().trim().split("\\s+");
            if (input2.length == 0) {
                System.out.println(-1);
                continue;
            }

            Node head = new Node(Integer.parseInt(input2[0]));
            Node tail = head;
            for (int i = 1; i < input2.length; i++) {
                tail.next = new Node(Integer.parseInt(input2[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            Node newHead = ob.reverseBetween(a, b, head);
            printList(newHead);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node reverse(Node head, int count){
        
        if(head == null) return null;
        Node prev = null;
        Node cur = head;
        while(cur != null && (count) >= 0){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        Node temp = prev;

       while(temp.next != null){
            temp = temp.next;
        }
            
        temp.next = cur;
        return prev;
    }
    public static Node reverseBetween(int m, int n,Node head)
    {
        //code here
        Node cur = head;
        int val = n-m;
        if(m > 1){
            while(cur != null && (m-1) > 1){
                cur = cur.next;
                m--;
            }
            cur.next = reverse(cur.next,val);
            return head;
        }
                
        return reverse(cur,val);
    }
}