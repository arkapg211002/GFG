//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] arr1 = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                arr1[i] = Integer.parseInt(numsStr1[i]);
            }

            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] arr2 = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                arr2[i] = Integer.parseInt(numsStr2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.LCIS(arr1, arr2));
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int LCIS(int[] arr1, int[] arr2) {
        // code here
        
         int[] dp = new int[arr2.length];
        int result = 0;

    // Traverse each element in arr1
    for (int i = 0; i < arr1.length; i++) {
        int currentMax = 0;

        // Traverse each element in arr2
        for (int j = 0; j < arr2.length; j++) {
            if (arr1[i] > arr2[j]) {
                // Update currentMax for any increasing sequence in arr2
                currentMax = Math.max(currentMax, dp[j]);
            } else if (arr1[i] == arr2[j]) {
                // Extend LCIS at arr2[j] using currentMax
                dp[j] = currentMax + 1;
            }
            // Update the result with the longest LCIS found so far
            result = Math.max(result, dp[j]);
        }
    }
    return result;
    }
}