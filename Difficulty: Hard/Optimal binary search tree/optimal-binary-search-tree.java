//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int keys[]= new int[n];
            for(int i = 0; i < n; i++)
                keys[i] = Integer.parseInt(input_line[i]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int freq[]= new int[n];
            for(int i = 0; i < n; i++)
                freq[i] = Integer.parseInt(input_line1[i]);
            Solution ob = new Solution();
            System.out.println(ob.optimalSearchTree(keys, freq, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    static int[][] dp;

    static int optimalSearchTree(int keys[], int freq[], int n) {

        dp = new int[n + 1][n + 1];

        for (int[] i: dp) Arrays.fill(i, -1);

        return helper(0, n - 1, keys, freq);

    }

    private static int helper(int i, int j, int[] keys, int[] freq) {

        if (i > j) return 0;

        if (i == j) return freq[i];

        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;

        for (int root = i; root <= j; root++) {

            int cost = helper(i, root - 1, keys, freq) +

                helper(root + 1, j, keys, freq) + arrSum(i, j, freq);

            minCost = Math.min(cost, minCost);

        }

        return dp[i][j] = minCost;

    }

    private static int arrSum(int i, int j, int[] freq) {

        int sum = 0;

        for (int x = i; x <= j; x++) sum += freq[x];

        return sum;

    }

}
