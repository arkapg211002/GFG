//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        // Space Optimization
        int max_ele = arr[0];
        for(int i =1;i<N;i++)
        {
            if(arr[i]>max_ele) max_ele = arr[i];
        }
        int m = 10*max_ele;
        int[] pre = new int[m+1];
        
        pre[0] = 1;
        for(int i = 1;i<=N;i++)
        {
            int[] cur = new int[m+1];
            for(int xr = 0;xr<=m;xr++)
            {
                int take  = 0;
                int notTake = pre[xr];
                if((arr[i-1]^xr) <= m)
                {
                    take = pre[arr[i-1]^xr];
                }
                cur[xr] = take+notTake;
            }
            pre = cur;
        }
        return pre[K];
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends