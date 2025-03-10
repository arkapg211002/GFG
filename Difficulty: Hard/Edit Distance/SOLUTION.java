//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends






class Solution {
    
    public static int f(String s1, String s2, int n, int m, int[][] dp){
        if(n==0){
            return m;
        }
        if(m==0){
            return n;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m]=f(s1,s2,n-1,m-1,dp);
        }
        return dp[n][m] = 1+Math.min(f(s1,s2,n-1,m,dp) ,Math.min( f(s1,s2,n,m-1,dp), f(s1,s2,n-1,m-1,dp)));
    }
    public int editDistance(String s1, String s2) {
        // Code here
        int n = s1.length();
        int m = s2.length();
        int [][] dp = new int[n+1][m+1];
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        
        return f(s1,s2,n,m,dp);
    }
}
