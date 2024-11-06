//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int i = 0; i <= n; i++) {
            	graph.add(new ArrayList<>());
            }
            
            int temp = n;
            while(temp-- > 1){
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            Solution ob = new Solution();
            System.out.println(ob.countOfNodes(graph, n));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        // To track if a node is visited
        boolean[] visited = new boolean[n + 1];
        // To count the number of nodes at even and odd levels
        int evenCount = 0, oddCount = 0;
        
        // Perform BFS starting from node 1 (since it's a connected graph)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);  // Start from node 1
        visited[1] = true;
        
        // Array to store level of each node
        int[] level = new int[n + 1];
        level[1] = 0;  // Start with level 0 for the root node (node 1)
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            // Check the level of the current node (even or odd)
            if (level[node] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            
            // Visit all neighbors of the current node
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    level[neighbor] = level[node] + 1;  // Set level for the neighbor
                    queue.add(neighbor);
                }
            }
        }
        
        // Calculate the number of pairs at even distances
        // Pairs from even level nodes: eC2 = e * (e - 1) / 2
        // Pairs from odd level nodes: oC2 = o * (o - 1) / 2
        int evenPairs = (evenCount * (evenCount - 1)) / 2;
        int oddPairs = (oddCount * (oddCount - 1)) / 2;
        
        // Return total pairs with even distance
        return evenPairs + oddPairs;
    }
}

