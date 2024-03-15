//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
    public Node sort(Node head){
        if(head == null || head.next == null || head.next.next == null) return head;
        Node ascend = head;
        Node ascendHead = ascend;
        Node descend = ascend.next;
        Node descendHead = descend;
        while(ascend.next != null && descend.next != null) {
            if(ascend.next != null) {
                ascend.next = ascend.next.next;
            }
            if(descend.next != null) {
                descend.next = descend.next.next;
            }
            if(ascend.next != null) 
            ascend = ascend.next;
            if(descend.next != null)
            descend = descend.next;
        }
        ascend.next = null;
        return join2SortedList(ascendHead, rev(descendHead));
    }
    
    public Node rev(Node head) {
       if(head == null || head.next == null) return head;
       Node prev = null;
       Node curr = head;
       Node next = curr.next;
       while(curr != null) {
           curr.next = prev;
           
           prev = curr;
           curr = next;
           if(next != null) next = next.next;
       }
       return prev;
    }
    
    public Node join2SortedList(Node node1, Node node2) {
        Node ans = new Node(0);
        Node ansHead = ans;
        while(node1 != null && node2 != null) {
            if(node1.data <= node2.data) {
                ans.next = node1;
                node1 = node1.next;
            }else {
                ans.next = node2;
                node2 = node2.next;
            }
            ans = ans.next;
            // System.out.println(ans.data);
        }
        if(node1 != null) {
            ans.next = node1;
        }
        if(node2 != null) {
            ans.next = node2;
        }
        return ansHead.next;
    }

}