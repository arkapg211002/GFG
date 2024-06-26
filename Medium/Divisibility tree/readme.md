https://www.geeksforgeeks.org/problems/divisibility-tree1902/1

```java
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] edges = IntMatrix.input(br, n - 1, 2);

            Solution obj = new Solution();
            int res = obj.minimumEdgeRemove(n, edges);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    private int dfs(List<Integer>[] adj, int node, int parent, int[] ans) {
        int cnt = 1;
        for(int it: adj[node]) {
            if(it != parent) {
                int cntNode = dfs(adj, it, node, ans);
                if(cntNode % 2 == 0) {
                    ans[0]++;
                }
                else {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int minimumEdgeRemove(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] ans = new int[1];
        dfs(adj, 1, -1, ans);
        return ans[0];
    }
}

```
