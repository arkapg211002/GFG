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
            
            Solution x = new Solution();
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

class Solution{
    Node searchNode(Node root, int target, Map<Node, Node> mp, Node parent) {
        if(root == null) return null;
        
        mp.put(root.left, root); 
        mp.put(root.right, root);
        
        Node left = searchNode(root.left, target, mp, root);
        Node right = searchNode(root.right, target, mp, root);
        
        if(root.data == target) {
            return root;
        } else if(left != null) {
            return left;
        } else if(right != null) {
            return right;
        } 
        return null;
        
    }
    int sum_at_distK(Node root, int target, int k){
        // Your code goes here
        
        Map<Node, Node> mp = new HashMap<>();
        Map<Node, Integer> visited = new HashMap<>();
        
        Node targetNode = searchNode(root, target, mp, null);
        Queue<Node> q = new LinkedList<>();
        
        q.add(targetNode);
        visited.put(targetNode, 1);
        q.add(null);
        
        int ans = 0;
        int t = 0;
        while(!q.isEmpty() && t <= k) {
            
            Node n = q.poll();
            
            if(n == null) {
                t++;
                if(q.size() > 0) 
                    q.add(null);
                continue;
            } else {
                ans += n.data;
            }
            
            
            if(n.left != null && !visited.containsKey(n.left)) {
                q.add(n.left);
                visited.put(n.left, 1);
            }
            if(n.right != null && !visited.containsKey(n.right)) {
                q.add(n.right);
                visited.put(n.right, 1);
            }
            if(mp.containsKey(n) && !visited.containsKey(mp.get(n)) && mp.get(n) != null) {
                q.add(mp.get(n));
                // System.out.println(mp.get(n).data);
                visited.put(mp.get(n), 1);
            }
        }
        q.clear();
        return ans;
        
        
    }
}
