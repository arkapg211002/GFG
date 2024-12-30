//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.offerings(N, arr));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    int offerings(int N, int arr[]){
        int []dp=new int[N];
        //left to right
        dp[0]=1;
        for(int i=1;i<N;i++){
            if(arr[i]>arr[i-1]){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=1;
            }
        }
        
        int sum=0;
        //right to left
        int count=1;
        dp[N-1]=Math.max(count,dp[N-1]);
        sum=dp[N-1];
        for(int i=N-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                count++;
            }else{
                count=1;
            }
            sum+=Math.max(count,dp[i]);
        }
        return sum;
    }
}