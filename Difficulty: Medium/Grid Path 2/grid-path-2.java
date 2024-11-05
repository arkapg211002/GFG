//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution 
{
    public int count(int n,int m,int [][]grid,int [][]dp)
    {
        int up=0;
        int left=0;
        
        if(n<0||m<0||grid[n][m]==1)
        return 0;
        
        if(n==0&&m==0)
        return 1;
        
        if(dp[n][m]!=-1)
        return dp[n][m];
        
        up=count(n-1,m,grid,dp);
        left=count(n,m-1,grid,dp);
        
        return dp[n][m]=(up+left)%1000000007;
        
    }
    
    public int totalWays(int N, int M, int grid[][]) 
    {
      int dp[][]=new int [N][M];
    
          for(int rows[]:dp)
               Arrays.fill(rows,-1);
     
     return count(N-1,M-1,grid,dp);
        
    }
}