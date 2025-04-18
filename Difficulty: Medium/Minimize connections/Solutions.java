//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] connections = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.minimumConnections(n,connections);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends





class Solution {
    static int parent[];
    static int rank[];
    
    static int findParent(int x) {
        if(x == parent[x]) {
            return x;
        }
        int p = findParent(parent[x]);
        parent[x]  = p;
        return p;
    }
    
    static void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px] ++;
        }
    }
    public static int minimumConnections(int n, int[][] connections) {
        // code here
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i<n; i++) {
            parent[i] = i;
        }
        int extraEdges = 0;
        for(int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            if(findParent(x) == findParent(y)){
                extraEdges ++;
            }
            union(x,y);
        }
        for(int i = 0; i<n; i++) {
            findParent(i);
        }
        
        int connectedComponents = 0;
        for(int i = 0; i<n; i++) {
            if(parent[i] == i) {
               connectedComponents++; 
            }
        }
        if(extraEdges >= connectedComponents -1) {
            return connectedComponents -1;
        } else {
            return -1;
        }
        
    }
}
