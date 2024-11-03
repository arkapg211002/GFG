//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
     
      Solution obj = new Solution();
      boolean ans = obj.checkSubsequenceSum(n,a,k);
      System.out.println(ans?"Yes":"No");
    
System.out.println("~");
}
  }
}

// } Driver Code Ends



//User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int n, int[] a, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] x: dp)
            Arrays.fill(x, -1);
        return solve(n, a, k, dp) == 1;
    }
    
    static int solve(int n, int[] a, int k, int[][] dp) {
        if (k < 0) return 0;
        if (n == 0) {
            if (k == 0) return 1;
            return 0;
        }
        
        if (dp[n][k] != -1) return dp[n][k];

        if (solve(n - 1, a, k - a[n - 1], dp) == 1) return dp[n][k] = 1;
        if (solve(n - 1, a, k, dp) == 1) return dp[n][k] = 1;

        return dp[n][k] = 2;
    }
}
     