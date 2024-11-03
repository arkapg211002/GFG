//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        
System.out.println("~");
}
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends




//User function Template for Java
/* Structre of the Node of the Binary Tree is as follows
     class Node
     {
         int data;
         Node left, right;
     }
*/

// your task is to complete this function
// function should create a new binary tree
// function should return the root node to the 
// new binary tree formed

class Solution {
    static int index = 0; // Index to track the current position in the pre[] array

    static Node help(int start, int end, int pre[], int preMirror[], int n) {
        // Base case: If we've reached the end of the pre[] array or the range is invalid
        if (index >= n || start > end) return null;

        // Base case: If we're at the last element or the range has only one element
        if (index == n - 1 || start == end) {
            Node temp = new Node(pre[index]);
            index++; // Increment the index
            return temp;
        }

        // Create a new node with the current element from the pre[] array
        Node temp = new Node(pre[index]);
        index++;

        // Find the mirror index in the preMirror[] array
        for (int i = start; i <= end; i++) {
            if (pre[index] == preMirror[i]) {
                // Construct the left subtree
                temp.left = help(i, end, pre, preMirror, n);
                // Construct the right subtree
                temp.right = help(start + 1, i - 1, pre, preMirror, n);
                break;
            }
        }

        return temp;
    }

    public Node constructBTree(int pre[], int preM[], int size) {
        // Initialize the index to 0
        index = 0;
        // Call the helper function to construct the tree
        return help(0, size - 1, pre, preM, size);
    }
}