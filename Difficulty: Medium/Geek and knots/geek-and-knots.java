//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int M = Integer.parseInt(a[0]);
            int N = Integer.parseInt(a[1]);
            int K = Integer.parseInt(a[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.knots(M, N, K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    static long mod=1000000007;
    static int knots(int M, int N, int K){
        // code here
        long [][]dp=new long[1001][1001];
        long a=comb(M,K,dp);
        long b=comb(N,K,dp);
        return (int)((a%mod * b%mod )%mod);
    }
    static long comb(int n,int k,long[][]dp){
        if(k==0 || k==n)return 1;
        if(dp[n][k]!=0)return dp[n][k];
        dp[n][k]=(comb(n-1,k,dp)%mod + comb(n-1,k-1,dp)%mod)%mod;
        return dp[n][k];
    }/*
    static int knots(int M, int N, int K){
        // code here
    }*/
}