//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(N);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }
            int S = sc.nextInt();
            int T = sc.nextInt();
            Solution ob = new Solution();
            int[] ans = ob.minimumCut(list, S, T, N);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    ArrayList<Integer> a1 = new ArrayList<Integer>();
    // Returns true if there is a path
    // from source 's' to sink 't' in residual 
    // graph. Also fills parent[] to store the path 
    private  boolean bfs(int[][] rGraph, int s,
                                int t, int[] parent) {
         
        // Create a visited array and mark 
        // all vertices as not visited     
        boolean[] visited = new boolean[rGraph.length];
         
        // Create a queue, enqueue source vertex
        // and mark source vertex as visited     
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;
         
        // Standard BFS Loop     
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i = 0; i < rGraph.length; i++) {
                if (rGraph[v][i] > 0 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    parent[i] = v;
                }
            }
        }
         
        // If we reached sink in BFS starting 
        // from source, then return true, else false     
        return (visited[t] == true);
    }
     
    // A DFS based function to find all reachable 
    // vertices from s. The function marks visited[i] 
    // as true if i is reachable from s. The initial 
    // values in visited[] must be false. We can also 
    // use BFS to find reachable vertices
    private  void dfs(int[][] rGraph, int s,
                                boolean[] visited) {
        visited[s] = true;
        for (int i = 0; i < rGraph.length; i++) {
                if (rGraph[s][i] > 0 && !visited[i]) {
                    dfs(rGraph, i, visited);
                }
        }
    }
 
    // Prints the minimum s-t cut
    private void minCut(int[][] graph, int s, int t) {
        int u,v;
         
        // Create a residual graph and fill the residual 
        // graph with given capacities in the original 
        // graph as residual capacities in residual graph
        // rGraph[i][j] indicates residual capacity of edge i-j
        int[][] rGraph = new int[graph.length][graph.length]; 
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                rGraph[i][j] = graph[i][j];
            }
        }
 
        // This array is filled by BFS and to store path
        int[] parent = new int[graph.length]; 
         
        // Augment the flow while there is path from source to sink     
        while (bfs(rGraph, s, t, parent)) {
             
            // Find minimum residual capacity of the edges 
            // along the path filled by BFS. Or we can say 
            // find the maximum flow through the path found.
            int pathFlow = Integer.MAX_VALUE;         
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }
             
            // update residual capacities of the edges and 
            // reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] = rGraph[u][v] - pathFlow;
                rGraph[v][u] = rGraph[v][u] + pathFlow;
            }
        }
         
        // Flow is maximum now, find vertices reachable from s     
        boolean[] isVisited = new boolean[graph.length];     
        dfs(rGraph, s, isVisited);
         
        // Print all edges that are from a reachable vertex to
        // non-reachable vertex in the original graph     
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) {
                    //System.out.println(i + " - " + j);
                    a1.add(i); 
                    a1.add(j); 
                }
            }
        }
    }
    
    public int[] minimumCut(ArrayList<ArrayList<Integer>> A, int S, int T, int N) {

        // Your code here
        
        int[][] graph=new int[N][N];
        a1.clear();
        for (int i = 0; i < A.size(); i++) { 
            for (int j = 0; j < A.get(i).size(); j++) { 
                //System.out.print(A.get(i).get(j) + " "); 
                graph[i][j]=A.get(i).get(j);
            } 
            //System.out.println(); 
        } 
        
         minCut(graph, S, T);
         
         if(a1.size()==0)
         {
            int[]g=new int[1];
            g[0]=-1;
            return g;
             
         }
         else
         {
             int[]g=new int[a1.size()];
            //g[0]=-1;
            //return g;
             for (int i = 0; i < a1.size(); i++)
             {
                g[i]=a1.get(i);   
                 
             }
             
             return g;
             
             
         }
             
         
         
         
         
    }
}