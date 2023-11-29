//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        
        while (tc-- > 0) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            
            List<Integer>[] adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            
            // String x=scanner.nextLine();
            // scanner.nextLine();
            
            Solution obj = new Solution();
            int ans = obj.isEulerCircuit(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution{
    
    public void dfs(int node, boolean visited[], List<Integer>[] adj) {
        visited[node] = true;
        for(int nei : adj[node]) {
            if(!visited[nei]) {
                dfs(nei, visited, adj);
            }
        }
    }
    
    public int isEulerCircuit(int V, List<Integer>[] adj) 
    {
        boolean visited[] = new boolean[V];
        dfs(0, visited, adj);
        
        for(int i=0; i<V; i++) {
            if(!visited[i] && adj[i].size()!=0) return 0;
        }
        
        int ed = 0;
        int od = 0;
        
        for(int i=0; i<V; i++) {
            if(adj[i].size()%2==0) {
                ed++;
            } else {
                od++;
            }
        }
        
        if (od == 2) {
            return 1;
        }
        
        if (od==0) {
            return 2;
        }
        
        return 0;
        
    }
}