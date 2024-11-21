//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        // Code here
        int n = prices.length;
        int []suff = new int[n+1];
        int ans = 0;
        for(int i = n-1; i >= 0; i--){
            suff[i] = Math.max(suff[i+1], prices[i]);
        }
        for(int i = 0; i < n-1; i++){
            ans = Math.max(ans, suff[i+1]-prices[i]);
        }
        return ans;
    }
}