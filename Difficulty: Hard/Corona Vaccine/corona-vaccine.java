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
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution g = new Solution();
            System.out.println(g.supplyVaccine(root));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} 
*/
class Marker{
    boolean gotVaccine;
    String isCovered;
    public Marker(boolean gotVaccine, String isCovered){
        this.gotVaccine = gotVaccine;
        this.isCovered = isCovered;
    }
}

class Solution{
    public static int supplyVaccine(Node root){
        return new Solution().bis(root);
    }
    int count = 0;
    int bis(Node node){
        if(node==null) return 0;
        else {
            if(node.left==null && node.right==null) return 1;
            else if(node.left==null || node.right==null){
                if(node.left!=null){
                    Marker m = traverse(node.left);
                    if(m==null){
                        return count+=1;
                    }else{
                        if(m.gotVaccine) return count;
                        else return count+=1;
                    }
                }else{
                    Marker m = traverse(node.right);
                    if(m==null){
                        return count+=1;
                    }else{
                        if(m.gotVaccine) return count;
                        else return count+=1;
                    }
                }
            }else{
                Marker left = traverse(node.left);
                Marker right = traverse(node.right);
                if(left==null || right==null) return count+=1;
                else{
                    if((!left.gotVaccine && !right.gotVaccine) || (((left.isCovered).equals("nc")) || ((right.isCovered).equals("nc")))){
                        count+=1;
                    }
                    return count;
                }
            }
        }
        
    }
    
    Marker traverse(Node node){
        if(node==null) return null;
        else{
            if(node.left==null && node.right==null) return null;
            else if(node.left==null || node.right==null){
                if(node.left==null){
                    Marker right = traverse(node.right);
                    if(right==null){
                        count+=1;
                        return new Marker(true, "c");
                    }else{
                        if(right.gotVaccine){
                            return new Marker(false, "c");
                        }else{
                            if((right.isCovered).equals("c")){
                                return new Marker(false, "nc");
                            }else{
                                count+=1;
                                return new Marker(true, "c");
                            }
                        }
                    }
                }else{
                    Marker left = traverse(node.left);
                    if(left==null){
                        count+=1;
                        return new Marker(true, "c");
                    }else{
                        if(left.gotVaccine){
                            return new Marker(false, "c");
                        }else{
                            if((left.isCovered).equals("c")){
                               return new Marker(false, "nc");
                            }else{
                                count+=1;
                                return new Marker(true, "c");
                            }
                        }
                    }
                }
            }else{
                Marker left = traverse(node.left);
                Marker right = traverse(node.right);
                if(left==null && right==null){
                    count+=1;
                    return new Marker(true, "c");
                }else if(left==null || right==null){
                    count+=1;
                    return new Marker(true, "c");
                }else{
                    if(left.gotVaccine){
                        if(right.gotVaccine){
                            return new Marker(false, "c");
                        }else{
                            if((right.isCovered).equals("c")){
                                return new Marker(false, "c");
                            }else{
                                count+=1;
                                return new Marker(true, "c");
                            }
                        }
                    }else{
                        if((left.isCovered).equals("c")){
                            if(right.gotVaccine){
                                return new Marker(false, "c");
                            }else{
                                if((right.isCovered).equals("c")){
                                    return new Marker(false, "nc"); 
                                }else{
                                    count+=1;
                                    return new Marker(true, "c");
                                }
                            }
                        }else{
                            count+=1;
                            return new Marker(true, "c");
                        }
                    }
                }
            }
        }
    }
}


