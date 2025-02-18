//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        
        int n = cost.length;
        
        // Initialize the first two steps
        for (int i = 2; i < n; i++) {
            // Update the current step cost to include the minimum of the last two steps
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        
        // Return the minimum cost to reach the top
        return Math.min(cost[n - 1], cost[n - 2]);
    }
};
