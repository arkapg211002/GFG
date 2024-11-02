//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());

            String input_line1[] = read.readLine().trim().split("\\s+");
            int pre[] = new int[n];
            for(int i=0;i<n;i++){
                pre[i] = Integer.parseInt(input_line1[i]);
            }

            String input_line2[] = read.readLine().trim().split("\\s+");
            char preLN[] = new char[n];
            for(int i=0;i<n;i++){
                preLN[i] = input_line2[i].charAt(0);
            }
            Solution obj = new Solution();
            Node root = obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/


/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
class Solution{
    int i=0;
    Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	    
	   if(i>=n)return null;
        
        Node root=new Node(pre[i]);
        if(preLN[i]=='N')
        {   
            i++;
            root.left=constructTree(n,pre,preLN);
            i++;
            if(i<n)
            root.right=constructTree(n,pre,preLN);
        }
        return root;
    }
}