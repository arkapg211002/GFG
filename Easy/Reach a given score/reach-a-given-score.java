//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    
    int[] moves = {3, 5, 10};
    public long count(int n) {
        // Add your code here.
        // long[][] dpm = new long[100001][3];
        // for(long[] arr : dpm)Arrays.fill(arr, -1);
        return solve(n);
    }
    long ans = 0;
    private long solve(int n, int i){
        if(n < 0)return 0;
        if(n == 0)return 1;
        if(i == 3)return 0;
        
        ans = solve(n-moves[i], i);
        ans += solve(n, i + 1);
        return ans;
    }
    private long solve(int n, int i, long[][] dp){
        if(n < 0)return 0;
        if(n == 0)return 1;
        if(i == 3)return 0;
        
        if(dp[n][i] != -1)return dp[n][i];
        
        ans = solve(n-moves[i], i);
        ans += solve(n, i + 1);
        return dp[n][i] = ans;
    }
    private long solve(int n){
        int[] arr = {3, 5, 10};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int move : arr) {
            for (int i = move; i <= n; i++) {
                dp[i] += dp[i - move];
            }
        }
        return dp[n];
    }
}