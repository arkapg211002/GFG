//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            boolean st=tr.IsFoldable(root);
	            if(st==true){
	                System.out.println("Yes");
	            }else{
	                System.out.println("No");
	            }
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*
node class of the binary tree
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
*/
class Tree{
    Node mirror(Node root){
        if(root == null){
            return root;
        }
        Node newroot = new Node(root.data);
        newroot.left = mirror(root.right);
        newroot.right = mirror(root.left);
        return newroot;
    }
    boolean isFold(Node root1,Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1.left == null && root2.left != null || root1.left != null && root2.left == null){
            return false;
        }
        if(root1.right == null && root2.right != null || root1.right != null && root2.right == null){
            return false;
        }
        return isFold(root1.left,root2.left) && isFold(root1.right,root2.right);
    }
    boolean IsFoldable(Node root) 
    { 
        // your code
        if(root == null){
            return true;
        }
        Node newroot = mirror(root);
        return isFold(root,newroot);
    }  
}
