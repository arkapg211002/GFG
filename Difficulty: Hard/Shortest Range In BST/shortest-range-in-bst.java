//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution sln = new Solution();
            Range rng = sln.shortestRange(root);
            System.out.println(rng.x + " " + rng.y);
        }
    }
}

class Range {
    int x, y;
    Range() {
        this.x = 0;
        this.y = 0;
    }
    Range(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public Range shortestRange(Node root) {
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        levelOrderTraversal(root,1,map);
        
        List<List<Integer>> level = new ArrayList<List<Integer>>();
        
        int i=1;
        while (map.get(i) != null) {
            level.add(map.get(i));
            i++;
        }
        return smallestRange(level);
    }
    Map<Integer,List<Integer>> levelOrderTraversal(Node node, int level, Map<Integer,List<Integer>> map) {
        if (node == null)
            return map;
        
        List<Integer> list = map.getOrDefault(level, new ArrayList<Integer>());
        list.add(node.data);
        
        map.put(level, list);
        
        levelOrderTraversal(node.left, level+1, map);
        levelOrderTraversal(node.right, level+1, map);
        
        return map;
    }
    public Range smallestRange(List<List<Integer>> nums) {
        if(nums.isEmpty()) return new Range(0,0);
        
        Range range = new Range(0, Integer.MAX_VALUE);
        
        PriorityQueue<LinkedList<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.peek() - b.peek()));
        PriorityQueue<LinkedList<Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.peek() - a.peek()));
        
        for(List<Integer> list: nums) {
            LinkedList<Integer> linkedList = new LinkedList<>(list);
            minHeap.add(linkedList);
            maxHeap.add(linkedList);
        }
    
        while(minHeap.size() == nums.size()) {
            LinkedList<Integer> minList = minHeap.poll();
            LinkedList<Integer> maxList = maxHeap.poll();
            
            int min = minList.getFirst();
            int max = maxList.getFirst();
            
            minList.removeFirst();
            
            if(minList.size() > 0) {
                minHeap.add(minList);
                maxHeap.add(maxList);
                if(!maxList.equals(minList)) {
                    maxHeap.remove(minList);
                    maxHeap.add(minList);
                }
            }
            if((range.y - range.x) > (max - min))
                range = new Range(min, max);
        }
        return range;
    }
}