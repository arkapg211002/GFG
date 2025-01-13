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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalWays(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int TotalWays(String str)
    {
        // Code here
        int mod = 1000000007;
        String s = "GEEKS";
        int n = str.length();
        int m = s.length();
        int dp[][] = new int[n +1][m +1];
        for(int i =0 ;i <=n;i++)
        {
            dp[i][0] =1;
        }
        
        for(int i =1;i<=n;i++)
        {
            for(int j =1;j <=m;j++)
            {
                if(str.charAt(i -1) == s.charAt(j -1))
                {
                    dp[i][j] = (dp[i -1][j -1] + dp[i -1][j]) % mod;
                }else
                {
                    dp[i][j] = dp[i -1][j] % mod;
                }
            }
        }
        return dp[n][m];
    }
}