// https://www.geeksforgeeks.org/problems/geek-and-its-game-of-coins4043/1

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        if (x <= n) dp[x] = true;
        if (y <= n) dp[y] = true;
        for (int i = 1; i <= n; i++) 
        {
            if ((i - 1 >= 0 && !dp[i - 1]) || (i - x >= 0 && !dp[i - x]) || (i - y >= 0 && !dp[i - y]))
                dp[i] = true;
        }
        return dp[n] ? 1 : 0;
    }
}
