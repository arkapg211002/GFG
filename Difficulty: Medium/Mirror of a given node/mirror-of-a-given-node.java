//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
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
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
	    	int target=Integer.parseInt(br.readLine());
		    Solution obj = new Solution();
		    int res = obj.findMirror(root,target);
		    System.out.println(res);
		
System.out.println("~");
}
	}
}
// } Driver Code Ends




//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution{
   
    public int findMirror(Node root,int target)
    {
        /*first we will find the path to reach the target
        //save this path in array list, 
        //such that left is  -1, and right is 1
        //and now we will reverse 1 to -1, and -1 to 1, and start to seacrch the value 
        //that exist in that path!*/
        
        ArrayList<Integer>path = new ArrayList<>();
        if(!findPath(root, target, path))return -1;
        
        int[]mirr = new int[path.size()];
        int i = 0;
        
        for(Integer n: path)mirr[i++] = -n;
        int[]num= {-1};
        mirro(root, mirr, 0, num);
        return num[0];
        
    }
    
    private boolean findPath(Node root, int target, ArrayList<Integer>path){
        if(root == null) return false;
        
        if(root.data == target) return true;;
        
        
        path.add(-1);
        if(findPath(root.left, target, path)) return true;
        path.remove(path.size()-1);
        
      
        path.add(1);
        if(findPath(root.right, target, path)) return true;
            
        
        path.remove(path.size()-1);
        
        return false;
    }
    
    private void mirro(Node root, int[]mirr, int i, int []num){
        if(root == null)return ;
        if(i==mirr.length){num[0] = root.data; return;}
        if(mirr[i] == -1){
            mirro(root.left, mirr, i+1, num);
        }
        
         if(mirr[i] == 1){
            mirro(root.right, mirr, i+1, num);
        }
    }
}