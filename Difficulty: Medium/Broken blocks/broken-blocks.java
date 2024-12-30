//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] matrix = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.MaxGold(matrix);
            System.out.println(ans);

        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int MaxGold(int[][] matrix)
    {
        // Code here
        int maxi = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        for(int col = 0; col < n; col++) {
            int res = this.maxGoldEarn(matrix, 0, col, m-1, n-1, dp);
            maxi = Math.max(maxi, res);
        }
        
        return maxi;
    }
    
    private int maxGoldEarn(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        
        if(j < 0 || j > n) {
            return 0;
        }
        
        if (matrix[i][j] == -1)
            return 0;
        
        if(i == m) {
            return matrix[m][j];
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        
        int down = matrix[i][j] +  maxGoldEarn(matrix, i+1, j, m, n, dp);
        
        int right = matrix[i][j] + maxGoldEarn(matrix, i+1, j+1, m, n, dp);
        
        int left = matrix[i][j] + maxGoldEarn(matrix, i+1, j-1, m, n, dp);
        
        return dp[i][j] = Math.max(down, Math.max(right, left));
    }
}