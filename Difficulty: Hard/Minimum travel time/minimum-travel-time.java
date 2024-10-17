//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int Solve(int n, int[][] grid) {
        // Code Here
        int time =0;
        DisjointSet uf = new DisjointSet(n*n);
        
        while(!uf.isConnected(0, n*n-1)){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] > time) continue;
                    if(i<n-1 && grid[i+1][j] <= time) uf.union(i*n+j, i*n+j+n);
                    if(j<n-1 && grid[i][j+1] <= time) uf.union(i*n+j, i*n+j+1);
                }
            }
            time += 1;
        }
        
        return time -1;
    }
    
    // Disjoint Set D.S Follow-Up Template!1
    static class DisjointSet {
        int size;
        int component;
        int [] parent;
        int [] rank;
        public DisjointSet(int n) {
            if(n <= 0)
                throw new IllegalArgumentException("Cannot be less than or equal to 0");
            size = n;
            component = n;
            parent = new int [n];
            rank = new int [n];
            for(int i=0; i<n; i++) parent[i] = i;
        }

        public int find(int p) {
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ) return;
            if(rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
            else{
                parent[rootQ] = rootP;
                if(rank[rootP] == rank[rootQ]) rank[rootP] += 1;
            }
            component -= 1;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}