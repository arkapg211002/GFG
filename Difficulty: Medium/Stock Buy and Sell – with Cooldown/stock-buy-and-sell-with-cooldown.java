//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    public long solve(int idx, int buy, int cool, long[] prices, long[][][] dp) {
        if(idx == prices.length) return 0;
        if(dp[idx][buy][cool]!=-1) return dp[idx][buy][cool];
        if(buy == 1) {
            if(cool == 1) {
                //not take 
                long nottake = solve(idx+1, buy, 0, prices, dp);
                return dp[idx][buy][cool] = nottake;
            }
            else {
                //take and not take
                long take = -prices[idx] + solve(idx+1, 0, 1, prices, dp);
                long nottake = solve(idx+1, buy, cool, prices, dp);
                
                return dp[idx][buy][cool] = Math.max(take, nottake);
            }
        }
        else {
            // take
            long take = prices[idx] + solve(idx+1, 1, 1, prices, dp);
            // not take
            long nottake = solve(idx+1, buy, 0, prices, dp);
            return dp[idx][buy][cool] = Math.max(take, nottake);
        }
    }
    public long maximumProfit(long prices[], int N){
        long[][][] dp = new long[N+1][2][2];
        for(long[][] it : dp) {
            for(long[] item : it) Arrays.fill(item, -1);
        }
        return solve(0, 1, 0, prices, dp);
    }
}