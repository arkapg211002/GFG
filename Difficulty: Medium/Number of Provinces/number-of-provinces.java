//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[]vis=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(vis,adj,i,V);
            }
        }
        return count;
    }
    static void dfs(boolean[]vis,ArrayList<ArrayList<Integer>> adj,int curr,int V){
        vis[curr]=true;
        
        for(int i=0;i<V;i++){
            if(!vis[i] && adj.get(curr).get(i)==1){
                dfs(vis,adj,i,V);
            }
        }
    }
};

