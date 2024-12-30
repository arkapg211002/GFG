//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int N = temp.length;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }
            Solution obj = new Solution();
            int res = obj.numberofLIS(arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    public int numberofLIS(int arr[]) {
        // Code here
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int numberOfLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                numberOfLIS += count[i];
            }
        }

        return numberOfLIS;
    }
    
}