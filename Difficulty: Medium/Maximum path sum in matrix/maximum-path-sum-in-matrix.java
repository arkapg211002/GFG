//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

 

    static int solve(int r, int c, int mat[][], int n, int dp[][]) {

        if (r == n)

            return 0;

        if (c < 0 || c == n)

            return Integer.MIN_VALUE;

 

        if (dp[r][c]!=-1) return dp[r][c];

 

        int res = mat[r][c]

                + Math.max(solve(r + 1, c, mat, n, dp), Math.max(solve(r + 1, c + 1, mat, n, dp), solve(r + 1, c - 1, mat, n, dp)));

       dp[r][c]=res;

       return res;

 

    }

 

    static int maximumPath(int n, int mat[][]) {

        // code

        int res = Integer.MIN_VALUE;

        int dp[][] = new int[n+1][n+1];

        for (int i=0; i<n+1; i++){

            for (int j=0; j<n+1; j++){

                dp[i][j] = -1;

            }

        }

        for (int i = 0; i < n; i++) {

            res = Math.max(res, solve(0, i, mat, n, dp));

        }

        return res;

    }

}