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
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String s) {
        // code here
        int n = s.length();
        int dp[] = new int[n];
        int res = 0;
        int lc = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') lc+=1;
            else if (lc > 0)
            {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                res = Math.max(res, dp[i]);
                lc-=1;
            }
        }
        return res;
    }
};