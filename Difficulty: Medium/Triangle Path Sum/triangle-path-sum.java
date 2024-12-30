//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle =
                new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int j = 0; j <= i; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minPathSum(triangle);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
    int n=triangle.size();
    int m=triangle.get(n-1).size();
    int[][] dp=new int[n][m];
    for(int i=0;i<m;i++)
    dp[n-1][i]=triangle.get(n-1).get(i);
    for(int i=n-2;i>=0;i--){
        for(int j=0;j<=i;j++)
        dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
    }
    return dp[0][0];
    }
}