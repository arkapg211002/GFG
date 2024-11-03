//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String in_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(in_line[0]);
            int Sum = Integer.parseInt(in_line[1]);

            Solution ob = new Solution();
            System.out.println(ob.countWays(n, Sum));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static long find(int n,int sum,long[][] dp){
        if(n==0){
            if(sum==0) return 1;
            return 0;
        }
        if(sum<0) return 0;
        if(dp[n][sum]!=-1) return dp[n][sum];
        long k=0;
        for(int i=0;i<10;i++){
            k=(k+find(n-1,sum-i,dp))%1000000007;
        }
        return dp[n][sum]=k; 
    }
    static long countWays(int n, int sum) {
        // code here
        long ans=0;
        long[][] dp=new long[n][sum+1];
        for(long[] t:dp) Arrays.fill(t,-1);
        for(int i=1;i<10;i++){
            ans=(ans+find(n-1,sum-i,dp))%1000000007;
        }
        return ans==0?-1:ans;
    }
}