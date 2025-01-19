//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int src = Integer.parseInt(s[2]);
            int dest = Integer.parseInt(s[3]);
            int X = Integer.parseInt(s[4]);
            ArrayList<ArrayList<Integer>> A = new ArrayList<>();
            for(int i = 0; i < M; i++)
                A.add(i, new ArrayList<Integer>());
            for(int i = 0; i < M; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                A.get(i).add(u);
                A.get(i).add(v);
                A.get(i).add(w);
            }
            Solution obj = new Solution();
            System.out.println(obj.exercise(N, M, A, src, dest, X));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    private String[] shoes = {"Neeman's Cotton Classics", "Neeman's Wool Joggers"};
    public String exercise(int N, int M, ArrayList<ArrayList<Integer>> A, int src, int dest, int X)
    {
        // Create adjacency list
        List<long[]> adj[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (var road : A) {
            int u = road.get(0);
            int v = road.get(1);
            int length = road.get(2);

            adj[u].add(new long[]{v, length});
            adj[v].add(new long[]{u, length});
        }

        // Create a distance array to store the shortest distance of a node from the source
        long[] distance = new long[N];
        Arrays.fill(distance, Long.MAX_VALUE);
        // Distance of source from source is '0'
        distance[src] = 0;

        // Create a priority queue with a comparator for sorting by distance
        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{src, 0});

        while (!pq.isEmpty()) {
            var arr = pq.poll();
            int node = (int) arr[0];
            long dist = arr[1];

            // Skip outdated distances
            if (dist > distance[node]) continue;

            // Process all adjacent nodes
            for (var adjNode : adj[node]) {
                int neighbour = (int) adjNode[0];
                long wt = adjNode[1];
                if (distance[neighbour] > dist + wt) {
                    distance[neighbour] = dist + wt;
                    pq.add(new long[]{neighbour, distance[neighbour]});
                }
            }
        }

        // Determine the shortest distance from src to dest
        long shortestDistance = distance[dest];

        // Return the appropriate shoe type
        return shortestDistance <= X ? shoes[0] : shoes[1];
    }
}