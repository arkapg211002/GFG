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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.FindNthTerm(n);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution
{
    long mod = (long)1e9+7;
    public int FindNthTerm(int n)
    {
        // code here
        if(n == 1){
            return 1;
        }
        long[][] res = help1(help(n-1),new long[][]{{1},{1}});
        return (int)res[0][0];
        
    }
    
    private long[][] help(int n){
        if(n == 1){
           return new long[][]{{1,1},{1,0}};
        }
        if(n%2 == 0){
            long[][] res = help(n/2);
            return help1(res,res);
        } else {
            return help1(help(n-1),help(1));
        } 
    }
    
    private long[][] help1(long[][] arr1, long[][] arr2){
        int n = arr1.length,n1=arr1[0].length,m=arr2[0].length;
        long[][] ans = new long[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                long res = 0;
                for(int k = 0;k<n1;k++){
                    res=(res+(arr1[i][k] * arr2[k][j]))%mod;
                }
                ans[i][j] = res;
            }
        }
        return ans;
    }
}