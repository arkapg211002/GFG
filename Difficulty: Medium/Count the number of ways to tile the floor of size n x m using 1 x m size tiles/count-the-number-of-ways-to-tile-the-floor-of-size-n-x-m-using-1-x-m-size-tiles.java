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
            String s = br.readLine().trim();
            String [] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.countWays(n, m);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    int mod = (int)1e9+7;
    public int countWays(int n, int m)
    {
        // Code here
        long dp[] = new long[n+1];
        for(int i = 0;i <=n;i++) {
            if(i < m) {
                dp[i] = 1;
            }
            else {
                dp[i] = (dp[i-1]%mod + dp[i-m]%mod)%mod;
            }
           
        }
        return (int)dp[n]%mod;
    }
}