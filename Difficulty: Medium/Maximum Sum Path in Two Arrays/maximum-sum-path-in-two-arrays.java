//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();

            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            line = read.readLine();
            tokens = line.split(" ");
            for (String token : tokens) {
                array2.add(Integer.parseInt(token));
            }

            // ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr1 = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr1[idx++] = i;

            int[] arr2 = new int[array2.size()];
            idx = 0;
            for (int i : array2) arr2[idx++] = i;

            int v = new Solution().maxPathSum(arr1, arr2);

            System.out.println(v);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    public int maxPathSum(int[] arr1, int[] arr2) {
        // code
         int i = 0, j = 0;
        int sum1 = 0, sum2 = 0, TotalSum = 0;

        // Sort the arrays if not already sorted
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Traverse both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                sum2 += arr2[j];
                j++;
            } else {
                // Common element encountered
                TotalSum += Math.max(sum1, sum2) + arr1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of arr1
        while (i < arr1.length) {
            sum1 += arr1[i];
            i++;
        }

        // Add remaining elements of arr2
        while (j < arr2.length) {
            sum2 += arr2[j];
            j++;
        }

        // Add the maximum of the remaining sums
        TotalSum += Math.max(sum1, sum2);

        return TotalSum;
    }
}