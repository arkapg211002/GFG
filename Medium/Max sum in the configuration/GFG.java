// https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1

//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Your code here
         long sum = 0;
        long totalSum = 0;

        // Ensure val is of type long to prevent overflow
        long val;
        for (int i = 0; i < n; i++) {
            val = i;
            sum += a[i];
            totalSum += val * a[i];
        }
        long max = totalSum;

        // N*a[n-i] will not cause overflow
        long N = n;

        for (int i = 1; i < n; i++) {
            totalSum = totalSum + sum - N * a[n - i];
            max = Math.max(max, totalSum);
        }
        return max;
    }
}
