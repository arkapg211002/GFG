//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    static int count(int N) 
    { 
        // code here
        
    
        
        
        
        int n = N/2;
        if( n == 1 || n == 2){
            return n;
        }
        
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        
        for(int i = 3; i<=n; i++){
            int ans = 0;
            for(int j = 0; j<i; j++){
                ans+=(dp[j]*dp[i-j-1]);
            }
            dp[i] = ans;
        }
        
        return dp[n];
    }
};