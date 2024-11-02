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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



class Solution {
    class DisjointSet{
        ArrayList<Integer> parent= new ArrayList<>();
        ArrayList<Integer> size= new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }
        public int getUPar(int node){
            if(parent.get(node)==node){
                return node;
            }
            int uPar= getUPar(parent.get(node));
            parent.set(node, uPar);
            return uPar;
        }
        public void unionBySize(int u, int v){
            int uPar= getUPar(u);
            int vPar= getUPar(v);
            if(uPar==vPar) return;
            if(size.get(uPar)>size.get(vPar)){
                parent.set(vPar, uPar);
                size.set(uPar, size.get(uPar)+size.get(vPar));
            }else{
                parent.set(uPar, vPar);
                size.set(vPar, size.get(uPar)+size.get(vPar));
            }
        }
    }

    public int Solve(int n, int[][] edge) {
        DisjointSet d = new DisjointSet(n);
        int extraEdge = 0;

        // Process each edge
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            // Check if u and v are in the same component
            if (d.getUPar(u) == d.getUPar(v)) {
                extraEdge++;  // This edge forms a cycle
            } else {
                d.unionBySize(u, v);  // Union the components of u and v
            }
        }

        // Count the number of connected components
        int cComp = 0;
        for (int node = 0; node < n; node++) {
            if (d.getUPar(node) == node) {
                cComp++;
            }
        }

        // Minimum edges needed to connect all components
        int ans = cComp - 1;

        // Check if we have enough extra edges to connect all components
        if (extraEdge >= ans) {
            return ans;
        }
        
        return -1;  // Not enough extra edges to connect all components
    }
}