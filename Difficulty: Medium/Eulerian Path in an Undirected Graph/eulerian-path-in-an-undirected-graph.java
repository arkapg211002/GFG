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
            int graph[][] = new int[N][N];
            for(int i = 0;i < N;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.eulerPath(N, graph));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution {
    static int eulerPath(int N, int[][] graph) {
        int oddDegreeCount = 0;

        // Count the degree of each vertex
        for (int i = 0; i < N; i++) {
            int degree = 0;
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    degree++;
                }
            }
            if (degree % 2 != 0) {
                oddDegreeCount++;
            }
        }

        // Check for Eulerian Path conditions
        return (oddDegreeCount == 2 || oddDegreeCount == 0) ? 1 : 0;
    }
}