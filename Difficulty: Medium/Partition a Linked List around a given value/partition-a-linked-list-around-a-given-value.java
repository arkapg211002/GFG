//{ Driver Code Starts
// Initial Template for Java
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

class Partition {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            int x = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            Node res = ob.partition(head, x);
            printList(res);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends




// User function Template for Java

/*class Node
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
    public static Node partition(Node head, int x) {
       
       //sorted or partitioning a linked list
       
       Node a = new Node(-1);
       Node b = new Node(-1);
       Node ta = a;
       Node tb = b;
       Node t = head;
       int count = 0;
       while(t!=null){
           if(t.data == x){
               count++;
               t = t.next;
               continue;
           }
           
           
           if(t.data<x){
               ta.next = t;
             ta = ta.next;
               
           }else{
               tb.next = t;
            
             tb = tb.next;
               
           }
             t = t.next;
          
       }
       for(int i = 1;i<=count;i++){
           Node n = new Node(x);
           ta.next = n;
           ta = ta.next;
       }
       
       
       
       
       tb.next = null;
       
       a = a.next;
       b = b.next;
       ta.next = b;
       return a;
       
       
    }
}