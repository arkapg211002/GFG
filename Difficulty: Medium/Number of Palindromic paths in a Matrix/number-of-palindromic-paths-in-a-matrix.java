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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] matrix = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    matrix[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countOfPalindromicPaths(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java


class Solution
{
    int mod = 1000000007;
    public int countOfPalindromicPaths(char[][] matrix)
    {
        // Code here
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][][][] = new int[m][n][m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<m;k++) {
                    for(int l=0;l<n;l++)
                    dp[i][j][k][l] = -1;
                }
            }
        }
        return count(matrix,0,0,m-1,n-1,m,n,dp);
    }
    public int count(char board[][],int src_i,int src_j,int dest_i,int dest_j,int m,int n,int dp[][][][]) {
        if(src_i<0||src_i>=m||dest_i<0||dest_i>=m)
        return 0;
        if(src_j<0||src_j>=n||dest_j<0||dest_j>=n)
        return 0;
        if(board[src_i][src_j]!=board[dest_i][dest_j])
        return 0;
        if(src_i==dest_i&&src_j==dest_j)
        return 1;
        if(src_i==dest_i&&dest_j-src_j==1) {
            return 1;
        }
        else if(src_j==dest_j&&dest_i-src_i==1) {
            return 1;
        }
        if(dp[src_i][src_j][dest_i][dest_j]!=-1)
        return dp[src_i][src_j][dest_i][dest_j];
        dp[src_i][src_j][dest_i][dest_j] = 0;
        //match 2
        int total = 0;
        total += count(board,src_i,src_j+1,dest_i,dest_j-1,m,n,dp);
        total %= mod;
        total += count(board,src_i,src_j+1,dest_i-1,dest_j,m,n,dp);
        total %= mod;
        total += count(board,src_i+1,src_j,dest_i,dest_j-1,m,n,dp);
        total %= mod;
        total += count(board,src_i+1,src_j,dest_i-1,dest_j,m,n,dp);
        total %= mod;
        dp[src_i][src_j][dest_i][dest_j] = total%mod;
        return dp[src_i][src_j][dest_i][dest_j];
    }
}