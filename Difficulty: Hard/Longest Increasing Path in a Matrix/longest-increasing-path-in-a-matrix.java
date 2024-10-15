//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.longestIncreasingPath(arr, n, m));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestIncreasingPath(int matrix[][], int n, int m) {
           int dp[][] = new int[n][m];
           for(int ref[] : dp) Arrays.fill(ref,-1);
           int max = 0;
           for(int r = 0; r < n; r++){
               for(int c = 0; c < m; c++)
                 max = Math.max(max,findmax(dp,matrix,r,c,-1));
           }
    return max;
    }
    int findmax(int dp[][], int M[][],int r, int c, int val){
        if(r < 0 || c < 0 || r == M.length || c == M[0].length || val >= M[r][c]) return 0;
        if(dp[r][c] > -1) return dp[r][c];
        return dp[r][c] = Math.max(Math.max(findmax(dp,M,r-1,c,M[r][c]),findmax(dp,M,r+1,c,M[r][c])),
        Math.max(findmax(dp,M,r,c-1,M[r][c]),findmax(dp,M,r,c+1,M[r][c])))+1;
    }
    
}