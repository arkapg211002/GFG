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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int MinSquares(int n) {
        // Code here
        // dp = new int[n+1][n+1];
        // for(int it[]:dp)Arrays.fill(it,-1);
        // int perfect[] = new int[n+1];
        // for(int i=1;i<=n;i++){
        //     perfect[i] = i*i;
        // }
        // return helper(perfect, n, 1, n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=n;j++){
                if(i-j*j >= 0){
                    dp[i] = Math.min(dp[i],1+dp[i-j*j]);
                }
            }
        }
        return dp[n];
    }
    int[][] dp = new int[1][1];
    int helper(int[] choices, int sum, int i, int n){
        if(sum == 0){
            return 0;
        }
        if(i > n ){
            return Integer.MAX_VALUE-10; 
        }
        else if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        else if(choices[i]>sum){
            return dp[i][sum] = helper(choices, sum , i+1, n);
        }
        else{
            return dp[i][sum] = Math.min(helper(choices, sum-choices[i], i, n)+1, helper(choices, sum,i+1, n));
        }
    }
}
