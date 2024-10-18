//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
        }
    }
}

// } Driver Code Ends


class Solution {
     private static boolean isSafe(int v, List<int[]> G, int[] colors, int c) {
        for (int[] edge : G) {
            if (edge[0] == v && colors[edge[1]] == c) {
                return false; // Adjacent vertex has the same color
            }
            if (edge[1] == v && colors[edge[0]] == c) {
                return false; // Adjacent vertex has the same color
            }
        }
        return true;
    }

    // Recursive function to perform graph coloring
    private static boolean graphColoringUtil(int v, List<int[]> G, int m, int[] colors) {
        // Base case: all vertices are assigned a color
        if (v == colors.length) {
            return true; // Successfully colored all vertices
        }

        // Try different colors for vertex 'v'
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, G, colors, c)) {
                colors[v] = c; // Assign color 'c' to vertex 'v'

                // Recur to assign colors to the next vertex
                if (graphColoringUtil(v + 1, G, m, colors)) {
                    return true; // If successful, return true
                }

                // Backtrack if coloring didn't lead to a solution
                colors[v] = 0; // Reset color for backtracking
            }
        }
        return false; // No valid coloring found
    }

    public static boolean graphColoring(int v, List<int[]> edges, int m) {
        int[] colors = new int[v]; // Initialize color array internally

        // Create adjacency list from edges
        List<int[]> G = new ArrayList<>(edges);

        return graphColoringUtil(0, G, m, colors);
    }
}

