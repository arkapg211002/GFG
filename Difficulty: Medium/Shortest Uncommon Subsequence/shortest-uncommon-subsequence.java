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
            String A[] = read.readLine().split(" ");
            
            String S = A[0];
            String T = A[1];

            Solution ob = new Solution();
            System.out.println(ob.shortestUnSub(S,T));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    int[][] memo;
    int shortestUnSub(String s, String t) {
        int n = s.length();
        int m = t.length();
        memo = new int[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) memo[i][j] = -1;
        
        int response = finder(s, t, n-1, m-1);
        if(response > 500) return -1;
        return response;
    }
    
    private int finder(String s, String t, int n, int m) {
        if(n < 0) return 501;
        if(m < 0) return 1;
        if(memo[n][m] != -1) return memo[n][m];
        
        int ind = -1;
        char ch = s.charAt(n);
        for(int i=m;i>=0;i--) {
            if(ch == t.charAt(i)) {
                ind = i;
                break;
            }
        }
        if(ind == -1) return memo[n][m] = 1; // single character not found
        return memo[n][m] = Math.min(1 + finder(s, t, n-1, ind-1), // include
                        finder(s, t, n-1, m)        // exclude
                        );
    }
};