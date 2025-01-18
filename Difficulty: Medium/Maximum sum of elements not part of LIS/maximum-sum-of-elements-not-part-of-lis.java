//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[] = new int[n];
            for (int i = 0; i < n; i++)
                Arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxSumLis(Arr, n));
        }
    }
}
// } Driver Code Ends






// User function Template for Java

class Solution {
    static int maxSumLis(int arr[], int n) {
        // code here
        int[] dp = new int[n];
        //The hash array is used to keep track of the indices of the elements that form the Longest Increasing Subsequence (LIS).
        // Specifically, for each element arr[i], the hash[i] stores the index of the previous element in the LIS that ends at arr[i].
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int sum = 0, lastIndex = 0, maxLen = 1, temp = 0;

        // Calculate total sum of the array
        for (int i = 0; i < n; i++) {
            hash[i] = i; //initialized such that hash[i] = i, meaning initially, each element is considered to be the start of a potential LIS, and it points to itself.
            sum += arr[i];
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && 1 + dp[prev] >= dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev; //hash[i] = prev: Update hash[i] to point to the previous index prev in the LIS.
                }
            }
            if (dp[i] >= maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // Calculate the sum of LIS elements
        temp += arr[lastIndex];
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            temp += arr[lastIndex];
        }

        // Return the maximum sum of elements not part of LIS
        return sum - temp;
    }
}