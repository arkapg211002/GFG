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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxAmount(Arr,n));
                }
        }
}    
// } Driver Code Ends




//User function Template for Java

class Solution
{
    int[][] dp;
    int maxAmount(int arr[] , int n)
    {
        dp = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) dp[i][j] = -1;
        return finder(arr, 0, n-1);
    }
    
    private int finder(int[] arr, int left, int right) {
        if(left > right) return 0;
        if(left == right) return arr[left];
        if(dp[left][right] != -1) return dp[left][right];
        
        return dp[left][right] = Math.max(
            arr[left] + Math.min(finder(arr, left+2, right), finder(arr, left+1, right-1)),
            arr[right] + Math.min(finder(arr, left, right-2), finder(arr, left+1, right-1))
        );
    }
}