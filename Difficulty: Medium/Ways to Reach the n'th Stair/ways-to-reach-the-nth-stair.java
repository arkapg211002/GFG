//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking count of stairs
            int m = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method countWays() of class
            // DynamicProgramming
            System.out.println(obj.countWays(m));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to count number of ways to reach the nth stair.
     int countWays(int n)
    {
        // Using Space optimization
        int mod = 1000000007;
        
        if (n == 0 || n == 1) {
            return 1;
        }

        int previous = 1;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = (previous + current) % mod;
            previous = temp;
        }
        return current % mod;
    }
}
