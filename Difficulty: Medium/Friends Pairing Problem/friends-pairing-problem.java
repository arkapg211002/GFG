//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
      int mod = 1000000007;
    public long countFriendsPairings(int n) 
    { 
       long res = 0;
       long[] dp = new long[n+1];
       Arrays.fill(dp, -1);
       return countPairs(n, dp)%mod;
    }
    
    long countPairs(int n, long[] dp){
        if(n<=2) return dp[n] = n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = countPairs(n-1, dp) + ((n-1)*countPairs(n-2, dp))%mod;
    }
}    
 