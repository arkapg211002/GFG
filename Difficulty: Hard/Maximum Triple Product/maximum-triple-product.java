//{ Driver Code Starts
//Initial Template for Javaimport java.io.*;

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            long x = ob.maxProductSum(N, arr);
            System.out.println(x);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   long maxProductSum(int N, int arr[])
   {
       // code here
       long dp[][]= new long[N][N];
       
       for(int g=0;g<dp.length;g++) // g indicates gap btwn i and j
       {
           // remember that  dp[i][j] dosen't solve for the value of array is i to j 
         // it solve for  the value of what max value we get when in arr we used i to j 
           //and left part  is 0 to i-1  & j+1 to N  which we done later on
           for(int i=0,j=g;j<dp.length;i++,j++)
           {
               long max=Integer.MIN_VALUE;
               for(int k=i;k<=j;k++)
               {
                   long left=(k==i?0:dp[i][k-1]);
                   long right=(k==j?0:dp[k+1][j]);
                   long extra=(i==0?1:Long.valueOf(arr[i-1]))*

 (Long.valueOf(arr[k]))*(j==dp.length-1?1:Long.valueOf(arr[j+1]));
                   long total=(left+right+extra);
                  if(total>max)
                    max=total;
               }
               dp[i][j]=max;
               
           }
       }
       return dp[0][N-1];
   }
}

