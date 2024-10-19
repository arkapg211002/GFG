//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    //do BFS or BFS before & after removing the edge 
    static void bfs(int src, ArrayList<ArrayList<Integer>> adj,int c,int d,boolean check,int[] visited)
    {
        Queue<Integer> q=new LinkedList<>();
        
        q.add(src);
        while(!q.isEmpty())
        {
            int node=q.poll();
            visited[node]=1;
            for(int next:adj.get(node))
            {
                if((check) &&((node==c && next==d )||( node==d && next==c)))
                   continue;
                if(visited[next]!=1)
                  q.add(next);
            }
        } 
    }
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
       
        
        int visited[]=new int[V];

//count no of disjoints before removing edge c-d
        Arrays.fill(visited,0);
        int disjointSets=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
               bfs(i,adj,c,d,false,visited) ;
               disjointSets++;
            }
        }

     //count no of disjoints after removing edge c-d
        Arrays.fill(visited,0);
        int disjointSets2=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
              {
                  bfs(i,adj,c,d,true,visited) ;
                   disjointSets2++;
              }
        }

//compare them
        if(disjointSets!=disjointSets2)
              return 1;
        return 0;
    }
}