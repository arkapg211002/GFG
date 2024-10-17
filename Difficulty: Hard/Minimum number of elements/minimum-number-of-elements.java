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
                    System.out.println(ob.minCount(Arr,n));
                }
        }
}    
// } Driver Code Ends


class Solution
{
    static int dp[][][] = new int[101][101][101];
    public static int solve(int arr[],int n,int i,int I,int D)
    {
        if(i<0)
        return 0;
        if(dp[i][I][D]!=-1)
        return dp[i][I][D];
        int ans = Integer.MIN_VALUE;
        if(I==n||arr[i]<arr[I])
        ans=Math.max(ans,solve(arr,n,i-1,i,D)+1); 
        if(D==n||arr[i]>arr[D])
        ans=Math.max(ans,solve(arr,n,i-1,I,i)+1);
        ans=Math.max(ans,solve(arr,n,i-1,I,D));
        return dp[i][I][D]=ans;
    }
    public int minCount(int arr[], int N)
    {
        for(int row1[][]:dp)
        for(int row[]:row1)
        Arrays.fill(row,-1);
        int c = solve(arr,N,N-1,N,N);
        return N-c;
    }
}
