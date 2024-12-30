//{ Driver Code Starts
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
    
	public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t > 0){
            String line = br.readLine().trim();
            Node root = buildTree(line);
            
            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int target = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);
            
            solver x = new solver();
            System.out.println( x.sum_at_distK(root, target, k) );
            t--;
        
System.out.println("~");
}
    }
}


// } Driver Code Ends




/*
// node structure:

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

*/

class solver{
    LinkedList<Node> container;
    int response = 0;
    int sum_at_distK(Node root, int src, int k){
        finder(root, src, new LinkedList<>());
        
        Node last = null;
        // System.out.println("Path: " + container.size());
        
        for(int i=container.size() - 1;i>=0 && k >= 0;i--) {
            Node curr = container.get(i);
            if(i == container.size() - 1) {
                calculator(curr, last, k);
            } else {
                calculator(curr, last, k);
            }
            last = curr;
            k-=1;
        }
        return response;
    }
    
        
    private void calculator(Node root, Node next, int k) {
        // System.out.println(root.data + " | " + k);
        if(root == null || k < 0) return;
        response+=root.data;
        if(root.left != next) calculator(root.left, next, k-1);
        if(root.right != next) calculator(root.right, next, k-1);
    }
    
    private void finder(Node root, int src, LinkedList<Node> path) {
        if(root == null || container != null) return;
        path.add(root);
        if(root.data == src) {
            container = new LinkedList<>(path);
            return;
        }
        finder(root.left, src, path);
        finder(root.right, src, path);
        path.removeLast();
    }
}