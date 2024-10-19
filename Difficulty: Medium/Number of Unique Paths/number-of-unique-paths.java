//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		while(t-->0)
		{
		    //taking dimensions of the matrix
		    int a=sc.nextInt();
		    int b=sc.nextInt();
		    Solution ob = new Solution();
		    //calling method NumberOfPath()
		    System.out.println(ob.NumberOfPath(a,b));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find total number of unique paths.
    static int find(int a,int b,int[][] dp){
        if(a==-1||b==-1) return 0;
        if(a==0&&b==0) return 1;
        return (dp[a][b]!=-1)?dp[a][b]:(dp[a][b]=(find(a-1,b,dp)+find(a,b-1,dp)));
    }
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int[][] dp=new int[a][b];
        for(int[] t:dp) Arrays.fill(t,-1);
        return find(a-1,b-1,dp);
    }
}