//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[v];
        for(int i=0; i<v; i++){
            color[i] = -1;
        }
        for(int i=0; i<v; i++){
            if(color[i] == -1){
                if(dfs(i, 0, color, adj) == false) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[node] = col;
        for(int it: adj.get(node)){
            if(color[it] == -1){
                if(dfs(it, 1-col, color, adj) == false){
                    return false;
                }
            }
            else if(color[it] == col) return false;
        }
        return true;
    }

}