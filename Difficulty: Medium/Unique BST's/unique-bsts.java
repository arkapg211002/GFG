//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return the total number of possible unique BST.
    static int numTrees(int N)
    {
        int mode = (int)1e9+7;
        long[]dp = new long[N+1];
        dp[0]=dp[1]=1;
        for(int i=2;i<=N;i++){
            int left = 0;
            int right = i-1;
            long sum = 0;
            while(left<right){
                sum = (sum+(dp[left]*dp[right])%mode)%mode;
                left++;
                right--;
            }
            if(i%2!=0){
                sum = (sum*2 + (dp[left]*dp[right])%mode)%mode;// both will we same left and right 
            }else{
                sum = (sum*2)%mode;
            }
            dp[i] = sum%mode;
        }
        
        return (int)dp[N]%mode;
    }
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking n
            int n =sc.nextInt();
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling method numTrees() of 
            //class Solution
            System.out.println(ob.numTrees(n));
        }
    }
}

// } Driver Code Ends