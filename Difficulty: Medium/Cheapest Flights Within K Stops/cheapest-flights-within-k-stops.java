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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        //do standard BFS, similar to Dijkshrats in DAG
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<Triplet> q=new LinkedList<>();
        int[] travelled=new int[n];
        for(int i=0;i<n;i++){
            travelled[i]=Integer.MAX_VALUE;
        }
        
        travelled[src]=0;
        q.add(new Triplet(src, 0, 0));
        
        while(q.size()>0){
            Triplet trip = q.poll();
            int curr=trip.ver;
            int dist=trip.dist;
            int count=trip.count;
            
            for(int i=0;i<adj.get(curr).size();i++){
                if(dist+adj.get(curr).get(i).dist <= travelled[adj.get(curr).get(i).ver] && count<=k){
                    travelled[adj.get(curr).get(i).ver] = dist+adj.get(curr).get(i).dist;
                    q.add(new Triplet(adj.get(curr).get(i).ver, travelled[adj.get(curr).get(i).ver], count+1));
                }
            }
        }
        return travelled[dst]==Integer.MAX_VALUE?-1:travelled[dst];
        
        
    }
    
    static class Pair{
        int ver;
        int dist;
        Pair(int ver, int dist){
            this.ver=ver;
            this.dist=dist;
        }
    }
    
    static class Triplet{
        int ver;
        int dist;
        int count;
        Triplet(int ver, int dist, int count){
            this.ver=ver;
            this.dist=dist;
            this.count=count;
        }
    }
}