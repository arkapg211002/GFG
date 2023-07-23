//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends




//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head){
    Node temp=head;
    int o=0;
    int z=0;
    int t=0;
    while(temp!=null){
        if(temp.data==0)
            z++;
        else if(temp.data==1)
            o++;
        else
            t++;
        temp=temp.next;
    }
    temp=head;
    while(temp!=null){
        if(z>0){
            temp.data=0;
            z--;
            temp=temp.next;
            continue;
        }
        if(o>0){
            temp.data=1;
            o--;
            temp=temp.next;
            continue;
        }
        if(t>0){
            temp.data=2;
            t--;
            temp=temp.next;
        }
    }
    return head;
}
}



