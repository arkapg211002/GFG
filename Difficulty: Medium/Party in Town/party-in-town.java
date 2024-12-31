//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    		for(int i = 0;i < N+1;i++){
    	        ArrayList<Integer> arr = new ArrayList<Integer>();
    	        adj.add(arr);
    		}
    		for(int i = 0;i < N-1;i++){
    		    String a[] = in.readLine().trim().split("\\s+");
    		    int x = Integer.parseInt(a[0]);
    		    int y = Integer.parseInt(a[1]);
    		    adj.get(x).add(y);
    		    adj.get(y).add(x);
    		}
    		
    		Solution ob = new Solution();
    		System.out.println(ob.partyHouse(N, adj));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
     private static int bfs(int v, boolean visited[], ArrayList<ArrayList<Integer>> adj, int N)
    {
        visited[v] = true;
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        int count = 0;
        
        queue.add(v);
        
        while(queue.isEmpty()==false)
        {
            int n = queue.size();
            
            for(int i=0; i<n; i++)
            {
                int u = queue.poll();
                
                for(int x : adj.get(u))
                {
                    if(visited[x]==false)
                    {
                        visited[x]=true;
                        queue.add(x);
                    }
                }
                
            }
            
            count++;
        }
        
        return count-1;
        
    }
    
    static int partyHouse(int N, ArrayList<ArrayList<Integer>> adj)
    {
        
        int mindist = Integer.MAX_VALUE;
        
        boolean visited[] = new boolean[N+1];
        
        for(int i=1; i<=N; i++)
        {
            Arrays.fill(visited, false);
            int dist = bfs(i, visited, adj, N);
            mindist = Math.min(mindist, dist);
        }
        
        return mindist;
        
        
    }
}