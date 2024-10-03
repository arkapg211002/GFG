//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
    
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
            input_line = read.readLine().trim().split("\\s+");
            for(int i=0;i<M;i++)
            {
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[3*i]));
                e.add(Integer.parseInt(input_line[3*i+1]));
                e.add(Integer.parseInt(input_line[3*i+2]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            int ans = ob.findMaxFlow(N, M, Edges); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int findMaxFlow(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    { 
        int graph[][] = new int[n+1][n+1];
        for (List<Integer> edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            int z = edge.get(2);
            graph[x][y] += z;
            graph[y][x] += z;
        }
        int src = 1, dest = n;
        int ans = 0;
        while (true) {
            Queue<Integer> q = new LinkedList<>();
            int parent[] = new int[n+1];
            q.add(src);
            while (q.size() > 0) {
                int x = q.remove();
                for (int y = 1; y <= n; y++) {
                    if (graph[x][y] > 0 && parent[y] == 0) {
                        parent[y] = x;
                        q.add(y);
                    } 
                }
            }
            if (parent[dest] == 0) {
                break;
            }
            int min = Integer.MAX_VALUE;
            for (int x = dest; x != src; x = parent[x]) {
                int y = parent[x];
                min = Math.min(min, graph[y][x]);
            }
            for (int x = dest; x != src; x = parent[x]) {
                int y = parent[x];
                graph[y][x] -= min;
                graph[x][y] += min;
            }
            if (min == Integer.MAX_VALUE) break;
            ans += min;
        }
        return ans;
    }
}