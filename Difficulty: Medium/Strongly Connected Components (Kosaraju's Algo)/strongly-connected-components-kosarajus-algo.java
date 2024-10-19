//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public void dfs(int node, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it, s, adj, vis);
            }
        }
        s.push(node);
    }
    
    public void revDfs(int node, ArrayList<ArrayList<Integer>> transpose, int[] vis){
        vis[node] =1;
        for(int it: transpose.get(node)){
            if(vis[it] == 0){
                revDfs(it, transpose, vis);
            }
        }
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i, s, adj, vis);
            }
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            transpose.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            vis[i] = 0;
            for(int it: adj.get(i)){
                transpose.get(it).add(i);
            }
        }
        int count = 0;
        while(s.size()>0){
            int node = s.peek();
            s.pop();
            if(vis[node] == 0){
                revDfs(node, transpose, vis);
                count++;
            }
        }
        return count;
    }
}
