//{ Driver Code Starts
// Contributed by Sudarshan Sharma
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            ArrayList<Integer> nodes = g.extremeNodes(root);
            for (int i = 0; i < nodes.size(); i++) {
                System.out.print(nodes.get(i) + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;

    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class Solution {
    public ArrayList<Integer> extremeNodes(Node root) {
        // add code here.
        ArrayList<Integer>res=new ArrayList<>();
        Queue<Node>q=new LinkedList<>();
        int f=1;
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer>internal=new ArrayList<>();
            for(int i=0;i<s;i++){
                Node t=q.remove();
                internal.add(t.data);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            if(f==1){
                res.add(internal.get(internal.size()-1));
            }
            else{
                res.add(internal.get(0));
            }
            f*=-1;
        }
        return res;
    }
}