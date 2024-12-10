//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            int[] arr = new int[2*e];
            
            for(int i=0; i<2*e; i++)
                arr[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.biGraph(arr,n,e));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    int[] inTime;
    int[] low;
    int timer = 1;
    boolean isArticulationPoint = false;
    
    int biGraph(int[] arr, int n, int e) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        inTime = new int[n];
        low = new int[n];
        
        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<arr.length;i+=2) {
            int a = arr[i];
            int b = arr[i+1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int cc = 0;
        for(int i=0;i<n && cc<2 && !isArticulationPoint;i++) {
            if(!visited[i]) {
                cc+=1;
                finder(i, -1);
            }
        }
        if(cc == 2) return 0;
        
        return isArticulationPoint == true ? 0 : 1;
    }
    
    private void finder(int n, int p) {
        if(isArticulationPoint) return;
        
        visited[n] = true;
        inTime[n] = low[n] = timer;
        timer+=1;
        
        int children = 0;
        for(Integer child : graph[n]) {
            if(child == p) continue;
            else if(visited[child]) {
                low[n] = Math.min(low[n], inTime[child]);
            } else {
                finder(child, n);
                if(p != -1 && low[child] >= inTime[n]) {
                    isArticulationPoint = true;
                    return;
                }
                children+=1;
                low[n] = Math.min(low[n], low[child]);
            }
        }
        
        if(p == -1 && children > 1) {
            isArticulationPoint = true;
            return;
        }
    }
};