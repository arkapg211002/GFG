//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     public int maximumPoints(int a[][], int N) {
        // code here
        int []prev=new int[3];
        for(int i=0;i<3;i++){
            prev[i]=a[0][i];
        }
        for(int i=1;i<N;i++){
            int cur[]=new int [3];
            for(int j=0;j<3;j++){
                int ans=0;
                for(int k=0;k<3;k++){
                    if(j!=k)
                   ans=Math.max(ans,a[i][j]+prev[k]); 
                }
                cur[j]=ans;
            }
            prev=cur;
            
        }
        int finalans=0;
        for(int i=0;i<3;i++){
            finalans=Math.max(finalans,prev[i]);
        }
        return finalans;
    }
    public int dowork(int [][]a,int days,int last,int[][]dp){
        if(days==0){
            int ans=0;
            for(int i=0;i<3;i++){
                if(last!=i){
                    ans=Math.max(a[0][i],ans);
                }
            }
            return ans;
        }
        
        if(dp[days][last]!=-1){
            return dp[days][last];
        }
        int ans=0;
        for(int i=0;i<3;i++){
            if(last!=i){
              ans=Math.max(a[days][i]+dowork(a,days-1,i,dp),ans);  
            }
        }
        return dp[days][last]=ans;
        
        
    }
}