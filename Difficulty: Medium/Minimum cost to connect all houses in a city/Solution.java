//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCostCity(edge, n);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private int[] parent, size;

    // Utility function to find the set of an element v using path compression technique
    private int find_set(int v) {
        if (v == parent[v]) {
            return v;
        }
        return parent[v] = find_set(parent[v]); // Path compression
    }

    // Function to perform the union of the sets a and b
    private boolean union_sets(int a, int b) {
        a = find_set(a);
        b = find_set(b);

        if (a != b) {
            if (size[a] < size[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            parent[b] = a;
            size[a] += size[b];
            return true;
        }
        return false;
    }

    // Function to create a Minimum Cost Spanning Tree for given houses
    public int minCostCity(int[][] houses, int n) {
        List<int[]> edges = new ArrayList<>();

        // Traverse each coordinate and calculate the Manhattan distance
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(houses[i][0] - houses[j][0]) +
                               Math.abs(houses[i][1] - houses[j][1]);
                edges.add(new int[] {distance, i, j});
            }
        }

        parent = new int[n];
        size = new int[n];

        // Sort all the edges based on Manhattan distance
        edges.sort(Comparator.comparingInt(a -> a[0]));

        // Initialize parent and size arrays
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int total_cost = 0;

        // Perform union and calculate the minimum spanning tree cost
        for (int[] edge : edges) {
            if (union_sets(edge[1], edge[2])) {
                total_cost += edge[0];
            }
        }

        return total_cost;
    }
}

