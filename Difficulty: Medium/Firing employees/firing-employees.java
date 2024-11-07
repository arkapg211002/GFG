//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.firingEmployees(arr,n));
            t--;
        
System.out.println("~");
}
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution {
      static boolean isPrime(int x){
        if(x<=1) return false;
        else if(x==2) return true;
        else if(x%2==0) return false;
        
        for(int i=3;i<=Math.sqrt(x);i+=2){
            if(x%i==0) return false;
        }
        return true;
    }
    
    static int dfs(int[] arr,int index,int[] dp){
        if(arr[index]==0) return 0;
        
        if(dp[index]!=-1) return dp[index];
        
        return dp[index]=1+dfs(arr,arr[index]-1,dp);
    }
    
    static int firingEmployees(int arr[], int n) { 
        // code here
        int ans=0;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            if(arr[i]==0) continue;
            int rank=i+1;
            int value=rank+dfs(arr,i,dp);
            if(isPrime(value)){
                ans++;
            }
        }
        return ans;
        
    } 
}