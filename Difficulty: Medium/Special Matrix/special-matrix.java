//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for (int i = 0; i < k; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution{
    public int NumberOfPath(int i,int j,int arr[][],int dp[][]){
        if(i >= 0 && j >= 0 && arr[i][j] == -1){
            return 0;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j]%1000000007;
        }
        int a = NumberOfPath(i-1,j,arr,dp);
        int b = NumberOfPath(i,j-1,arr,dp);
        return dp[i][j] = (a%1000000007 + b%1000000007)%1000000007;
    }
    public int FindWays(int n, int m, int[][] mat){
        // Code here
       int maze[][] = new int[n][m];
       for(int i = 0;i <= mat.length - 1;i++){
              int a = mat[i][0]-1;
              int b = mat[i][1]-1;
              maze[a][b] = -1;
       }
       int dp[][] = new int[n][m];
       for(int i = 0;i <= n - 1;i++){
           for(int j = 0; j <= m - 1; j++){
              dp[i][j] = -1;
           }
       }
       return NumberOfPath(n-1,m-1,maze,dp)%1000000007;
    }
}