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
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        int maxSum = Integer.MIN_VALUE; // Initialize maximum sum
        int left, right, i;
        
        // Step 1: Iterate through all pairs of columns
        for (left = 0; left < C; left++) {
            // Initialize a temporary array for row sums
            int[] temp = new int[R];
            
            for (right = left; right < C; right++) {
                // Step 2: Calculate the sum of elements between the left and right columns
                for (i = 0; i < R; i++) {
                    temp[i] += M[i][right];
                }
                
                // Step 3: Apply Kadane's algorithm on temp array to find the maximum sum subarray
                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }
        
        return maxSum;
    }
    
    // Helper method to apply Kadane's algorithm
    private int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
};