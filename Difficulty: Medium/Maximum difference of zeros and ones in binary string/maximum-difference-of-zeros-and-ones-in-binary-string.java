//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String S) {
        // code here
        int n = S.length();
        int dp[] = new int[n+1];
        int max = -1;
        for(int i=n-1; i>=0; i--){
            char c = S.charAt(i);
            if(c=='0'){
                dp[i] = Math.max(1, dp[i+1]+1);
                max= Math.max(max, dp[i]);
            }
            else{
                dp[i] = dp[i+1]-1;
            }
        }
        return max;
        
    }
}