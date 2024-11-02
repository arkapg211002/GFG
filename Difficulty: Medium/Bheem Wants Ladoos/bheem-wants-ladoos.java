//{ Driver Code Starts
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String line = br.readLine().trim();
            Node root = buildTree(line);

            line = br.readLine().trim();
            String target_k[] = line.split(" ");
            int home = Integer.parseInt(target_k[0]);
            int k = Integer.parseInt(target_k[1]);

            Solution x = new Solution();
            System.out.println(x.ladoos(root, home, k));
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

class Solution {
     private Node findTarget(Node root, int home) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == home) return curr;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        return null; // Return null if not found
    }

    // Create a mapping of child nodes to their parents
    private void makeParent(Node root, Map<Node, Node> parent) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                parent.put(curr.left, curr);
            }
            if (curr.right != null) {
                q.add(curr.right);
                parent.put(curr.right, curr);
            }
        }
    }

    // Calculate the sum of node values up to k distance from the target node
    public int ladoos(Node root, int home, int k) {
        int res = 0;
        Node target = findTarget(root, home);
        if (target == null) return res; // Handle the case where the target is not found

        Map<Node, Node> parent = new HashMap<>();
        makeParent(root, parent);
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        Set<Node> visited = new HashSet<>();
        visited.add(target);
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            if (level++ > k) break;
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                res += curr.data;

                // Check left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                // Check right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                // Check parent
                if (parent.containsKey(curr) && !visited.contains(parent.get(curr))) {
                    q.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
        }
        return res;
    }
}
