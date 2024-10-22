//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < s1.length; i++) nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int find(int[] arr, int sum, int[] dp){
        if(sum<0) return Integer.MAX_VALUE;
        if(sum==0) return 0;
        if(dp[sum]!=-1)  return dp[sum];
        int ans=Integer.MAX_VALUE;
        for(int a:arr){
            int k=find(arr,sum-a,dp);
            if(k!=Integer.MAX_VALUE) ans=Math.min(ans,k+1);
        }
        return dp[sum]=ans;
    }
    public int MinCoin(int[] arr, int sum) {
        // Code here
        int[] dp=new int[sum+1];
        Arrays.fill(dp,-1);
        int ans=find(arr,sum,dp);
        return ans==2147483647?-1:ans;
    }
}