//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            int V[][] = new int[M+1][2];
            for(int i=0;i<M;i++){
                String input_line1[] = read.readLine().trim().split("\\s+");
                V[i][0] = Integer.parseInt(input_line1[0]);
                V[i][1] = Integer.parseInt(input_line1[1]);
            }
            Solution ob = new Solution();
            int ans = ob.captainAmerica(N, M, V);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    // Iterative DFS function to traverse the graph
    void dfs(int node, int[] vis, List<Integer> adj[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        vis[node] = 1;
        
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            
            for (int neighbor : adj[currNode]) {
                if (vis[neighbor] == 0) {
                    stack.push(neighbor);
                    vis[neighbor] = 1;
                }
            }
        }
    }

    // Iterative DFS to count reachable nodes from the mother vertex
    int dfsCount(int node, int[] vis, List<Integer> adj[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        vis[node] = 1;
        int count = 0;
        
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            count++;
            
            for (int neighbor : adj[currNode]) {
                if (vis[neighbor] == 0) {
                    stack.push(neighbor);
                    vis[neighbor] = 1;
                }
            }
        }
        
        return count;
    }

    // Function to find the mother vertex in the graph
    int findMotherVertex(int V, List<Integer> adj[]) {
        int[] vis = new int[V + 1];
        int motherVertex = 0;

        // Perform iterative DFS for all vertices
        for (int i = 1; i <= V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj);
                motherVertex = i;
            }
        }

        // Reset the visited array
        Arrays.fill(vis, 0);

        // Check if the mother vertex can reach all nodes
        dfs(motherVertex, vis, adj);

        for (int i = 1; i <= V; i++) {
            if (vis[i] == 0) return -1;
        }

        return motherVertex;
    }

    // Main function to solve the problem
    public int captainAmerica(int N, int M, int[][] V) {
        // Create adjacency list and transpose adjacency list
        List<Integer>[] adj = new ArrayList[N + 1];
        List<Integer>[] adjT = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            adjT[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = V[i][0];
            int v = V[i][1];
            adj[u].add(v);
            adjT[v].add(u);
        }

        // Find the mother vertex using transpose adjacency list
        int motherVertex = findMotherVertex(N, adjT);

        if (motherVertex == -1) return 0;

        // Count the nodes reachable from the mother vertex in the original graph
        int[] vis = new int[N + 1];
        int count = dfsCount(motherVertex, vis, adj);

        return count;
    }
}


