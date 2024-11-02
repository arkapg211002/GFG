//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());

            int res = new Solution().countWays(n);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends













class Solution {
    // function to count ways in which n can be expressed as the sum of two or more integers
    int countWays(int n) {
        // Modulo value as per the problem statement
        final int MOD = 1000000007;

        // Create a DP array
        int[] dp = new int[n + 1];
        
        // Base case
        dp[0] = 1; // Only one way to make sum 0
        
        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - i]) % MOD;
            }
        }

        // The result will be in dp[n], but we need to subtract 1
        // to exclude the case where n is not split (i.e., only one way to represent n)
        return (dp[n] - 1 + MOD) % MOD; // Ensure non-negative result
    }
}