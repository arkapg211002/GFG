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
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int distinctSubsequences(String s) {
        int MOD = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;

        Map<Character, Integer> lastSeen = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % MOD;

            char c = s.charAt(i - 1);
            if (lastSeen.containsKey(c)) {
                int lastIndex = lastSeen.get(c);
                dp[i] -= dp[lastIndex - 1];
                dp[i] = (dp[i] + MOD) % MOD;
            }

            lastSeen.put(c, i);
        }

        return (int) dp[n];
    }
}