//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            String X = input[0];
            String Y = input[1];
            
            Solution ob = new Solution();
            int result = ob.stringConversion(X,Y);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends






//User function Template for Java

class Solution {
    public int stringConversion(String X, String Y) {
        int n = X.length();
        int m = Y.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base cases
        dp[0][0] = true; // Both strings are empty
        for (int i = 1; i <= n; i++) {
            // If Y is empty, we can delete all lowercase letters in X
            dp[i][0] = dp[i - 1][0] && Character.isLowerCase(X.charAt(i - 1));
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char xChar = X.charAt(i - 1);
                char yChar = Y.charAt(j - 1);

                if (Character.toUpperCase(xChar) == yChar) {
                    // Either match directly or convert lowercase to uppercase
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (Character.isLowerCase(xChar)) {
                    // Option to delete the lowercase character
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m] ? 1 : 0;
    }
}