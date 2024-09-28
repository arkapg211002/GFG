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
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] a) {
        int n = N+2;
        int[] c = new int[n];
        c[0] = c[n-1] = 1;
        System.arraycopy(a,0,c,1, N);
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>0; i--){
            for(int j=i+1; j<n; j++){
                int total = Integer.MIN_VALUE;
                for(int k=i; k<j; k++){
                    int product = c[i-1] * c[k] * c[j];
                    int memoized = dp[i][k-1] + dp[k+1][j-1];
                    total = Math.max(total, product+memoized);
                }
                dp[i][j-1] = total;
            }
        }
        return dp[1][N];
    }
}
     