//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// Time Complexity: O((V+E) log V), here V is number of cities and E is number of flights. 
// Auxiliary Space: O(V+E), here V is number of cities and E is number of flights.

// User function Template for Java

class Solution {

    class Pair {
        int city, cost;
        Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public int minimumCost(int[][] flights, int n, int k) {
        // Create an adjacency list to store the graph
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the adjacency list with the flights data
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            graph.get(u).add(new Pair(v, w));
        }
        
        // Use Dijkstra's algorithm to find the shortest paths
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(k, 0));
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;
            
            if (currentCost > dist[currentCity]) {
                continue;
            }
            
            for (Pair neighbor : graph.get(currentCity)) {
                int nextCity = neighbor.city;
                int nextCost = neighbor.cost;
                
                if (dist[currentCity] + nextCost < dist[nextCity]) {
                    dist[nextCity] = dist[currentCity] + nextCost;
                    pq.add(new Pair(nextCity, dist[nextCity]));
                }
            }
        }
        
        // Find the maximum cost from k to any other city
        int maxCost = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // If there's a city unreachable from k
            }
            maxCost = Math.max(maxCost, dist[i]);
        }
        
        return maxCost;
    }
}