//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  V = Integer.parseInt(input_line[0]);
            int  E = Integer.parseInt(input_line[1]);
            int  K = Integer.parseInt(input_line[2]);
            int A[] = new int[3*E + 1];
            String input_line1[] = read.readLine().trim().split("\\s+");
            for(int i=0;i<3*E;i++){
                A[i] = Integer.parseInt(input_line1[i]);
            }
        
            Solution ob = new Solution();
            if(ob.pathMoreThanK(V, E, K, A)){
                System.out.println(1);
            } else{
                System.out.println(0);   
            }
        }
    }
}


// } Driver Code Ends




//User function Template for Java

class Solution{
    class edge{
        int dst;
        int cost;
        public edge(int d,int c){
            this.dst=d;
            this.cost=c;
        }
    }
    boolean check(ArrayList<edge> graph[],int src,int k,boolean vis[],int total){
        //   System.out.println(total);
        if(vis[src]){
            return false;
        }
        if(total>=k){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            if(!vis[graph[src].get(i).dst]){
                if(check(graph, graph[src].get(i).dst, k, vis, total+graph[src].get(i).cost)){
                    return true;
                }
            }
        }
        vis[src]=false;
        return false;
    }
    boolean pathMoreThanK(int V , int E , int K , int []a){
        ArrayList<edge> graph[]=new ArrayList[V];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
         
        for(int i=0;i<a.length-1;i+=3){
            // System.out.println(a[i]);
            graph[a[i]].add(new edge(a[i+1], a[i+2]));
            graph[a[i+1]].add(new edge(a[i], a[i+2]));
        }
        boolean vis[]=new boolean[graph.length];
       return check(graph, 0, K, vis, 0);
    }
    
}