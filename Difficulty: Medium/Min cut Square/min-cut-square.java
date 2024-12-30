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
                    int m = sc.nextInt();
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCut(m,n));
                }
        }
}    
// } Driver Code Ends



class Solution
{
	public int minCut(int M, int N)
	{
        // Your code goes here
        int[][] dp = new int[M+1][N+1];
        for(int i=0;i<=M;i++){
            Arrays.fill(dp[i],-1);
        }
        int result = cuts(M,N,dp);
        return result;
	}
	private int cuts(int m, int n,int[][] dp){
	    if(m == n){
	        return 1;
	    }
	    if(dp[m][n] != -1){
	        return dp[m][n];
	    }
	    
	    int minSquares =Integer.MAX_VALUE;
	    //vertical
	    for(int i=1;i<m;i++){
	        int squares =  cuts(i,n,dp)+cuts(m-i,n,dp); 
	        minSquares = Math.min(minSquares, squares);
	    }
	    for(int i=1;i<n;i++){
	        int squares =  cuts(m,i,dp)+cuts(m,n-i,dp);
	        minSquares = Math.min(minSquares,squares);
	    }
	    return dp[m][n] = minSquares;
	}
}