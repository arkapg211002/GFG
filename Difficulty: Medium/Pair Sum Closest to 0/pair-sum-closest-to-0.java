//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)throws IOException
    {
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int[] arr = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; ++i)
                arr[i] = Integer.parseInt(s[i]);

    		out.println (new Solution().closestToZero (arr, n));
        }
        out.close();
        
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int closestToZero (int arr[], int n)
    {
        // your code here
         Arrays.sort(arr);
        if(n==1)
            return arr[0]*2;
        if(arr[n-1]<=0){
            return (arr[n-1]+arr[n-2]);
        }
        if(arr[0]>=0){
            return (arr[0]+arr[1]);
        }
        int low = 0;
        int high = n-1;
        int minSum = Integer.MAX_VALUE;
        while(low<high){
            int sum = arr[low]+arr[high];
            if(Math.abs(sum)<Math.abs(minSum)){
                minSum = sum;
            }
            if(Math.abs(sum)==Math.abs(minSum)){
                minSum = Math.max(sum,minSum);
            }
            if(sum<0){
                low++;
            }
            else if(sum>0){
                high--;
            }
            else if(sum==0){
                return 0;
            }
        }
        return minSum;
    }
}