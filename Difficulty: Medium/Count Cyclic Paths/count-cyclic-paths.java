//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

//User function Template for Java

class Solution{
    
    static int MOD = 1000000007;
    public static int solve(int n, int last, int[][]dp) {
        if (n == 1) {
            return 1;
        }
        
        if(dp[n][last]!=-1){
            return dp[n][last];
        }
        
        int value = 0;
        if (n == 2) {
           
            for (int i = 0; i < 4; i++) {
                if (i != last && i != 3) { //can't take O at the last - A, B, C can be taken
                    value = (value % MOD + solve(n - 1, i,dp) % MOD) % MOD;
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (i != last) { //can't take O at the last - A, B, C can be taken
                    value = (value % MOD + solve(n - 1, i, dp) % MOD) % MOD;
                }
            }
        }
        return (dp[n][last]=value);
    }
    
 public static int countPaths(int n) {
        if (n == 1) {
            return 0;
        }

        int[][] dp = new int[n + 1][4];

        for (int i = 0; i < 4; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (i == 2) {

                for (int last = 0; last < 4; last++) {
                    dp[i][last] = 0;
                    for (int j = 0; j < 4; j++) {
                        if (last != j && j != 3) {
                            dp[i][last] = (dp[i][last] % MOD + dp[i - 1][j] % MOD) % MOD;
                        }
                    }
                }
            } else {
                for (int last = 0; last < 4; last++) {
                    dp[i][last] = 0;
                    for (int j = 0; j < 4; j++) {
                        if (last != j) {
                            dp[i][last] = (dp[i][last] % MOD + dp[i - 1][j] % MOD) % MOD;
                        }
                    }
                }
            }
        }
        return dp[n][3];

    }
		//code here
	    
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends