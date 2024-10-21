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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int MOD=1000000007;
    static int numOfWays(int n, int x)
    { 
        int [][] dp = new int[n+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) dp[i][j] = -1;
        }
        return calculateWays( n, x,1, dp);
    }
    static int calculateWays(int n,int x,int i, int [][] dp)
    {
        if(n==0)
        return 1;
        if(n-Math.pow(i,x)<0){
            return 0;
        }
        if(dp[i][n] != -1) return dp[i][n];
        int include=calculateWays((int)(n-Math.pow(i,x)),x,i+1,dp);
        include%=MOD;
        int exclude=calculateWays(n,x,i+1,dp);
        exclude%=MOD;
        return  dp[i][n] = (include+exclude)%MOD;
    }
}