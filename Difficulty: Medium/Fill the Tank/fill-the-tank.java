//{ Driver Code Starts
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
            int N = Integer.parseInt(input_line[0]);
            int S = Integer.parseInt(input_line[1]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int cap[] = new int[N];
            for(int i=0;i<N;i++){
                cap[i] = Integer.parseInt(input_line1[i]);
            }
            int Edges[][] = new int[N-1][2];
            for(int i=0;i<N-1;i++){
                String input_line2[] = read.readLine().trim().split("\\s+");
                Edges[i][0] = Integer.parseInt(input_line2[0]);
                Edges[i][1] = Integer.parseInt(input_line2[1]);
            }
            Solution ob = new Solution();
            long ans = ob.minimum_amount(Edges, N, S, cap);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}



// } Driver Code Ends



class Solution {

    long minimum_amount(int[][] edges, int numTanks, int sourceTank, int[] capacities) {
        // Create an adjacency list to represent the graph (tree) of water tanks
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= numTanks; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list from the given edges
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // Array to keep track of visited tanks during DFS
        boolean[] visited = new boolean[numTanks + 1];

        // Start DFS from the source tank to calculate the minimum amount of water required
        long totalWaterNeeded = dfs(sourceTank, adjacencyList, capacities, visited);

        // If the result is -1, it indicates an error in filling the tanks
        if (totalWaterNeeded == -1) return -1;
        return totalWaterNeeded; // Return the total water needed to fill all tanks
    }

    long dfs(int currentTank, ArrayList<ArrayList<Integer>> adjacencyList, int[] capacities, boolean[] visited) {
        // Mark the current tank as visited
        visited[currentTank] = true;

        // Variables to track the maximum water required and the number of children
        long maxWaterRequired = 0L;
        long numberOfChildren = 0L;

        // Set an upper limit for the maximum amount of water available
        long maxAvailableWater = 1000000000000000000L;

        // Iterate over the adjacent tanks (children) of the current tank
        for (int adjacentTank : adjacencyList.get(currentTank)) {
            if (!visited[adjacentTank]) { // If the adjacent tank hasn't been visited
                numberOfChildren++; // Increment the number of children
                long childWaterNeeded = dfs(adjacentTank, adjacencyList, capacities, visited); // Recursive DFS call
                
                // If a child returns -1, it indicates that filling was not possible
                if (childWaterNeeded == -1) return -1;

                // Update the maximum water needed from child tanks
                maxWaterRequired = Math.max(maxWaterRequired, childWaterNeeded);
            }
        }

        // Calculate the total water needed for the current tank, including its own capacity
        maxWaterRequired = maxWaterRequired * numberOfChildren + capacities[currentTank - 1];

        // If the calculated water exceeds the maximum available water, return -1
        if (maxWaterRequired > maxAvailableWater) {
            return -1;
        }
        
        // Return the total water needed for this tank
        return maxWaterRequired;
    }
}