//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            ArrayList<Integer> array1 = new ArrayList<>();
            ArrayList<Integer> array2 = new ArrayList<>();

            String line = read.readLine().trim(); // Read the first array
            if (!line.isEmpty()) {                // Check if the line is not empty
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    array1.add(Integer.parseInt(token));
                }
            }

            line = read.readLine().trim(); // Read the second array
            if (!line.isEmpty()) {         // Check if the line is not empty
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    array2.add(Integer.parseInt(token));
                }
            }

            // Convert ArrayList to arrays for processing
            int[] arr = new int[array1.size()];
            for (int i = 0; i < array1.size(); i++) {
                arr[i] = array1.get(i);
            }

            int[] q = new int[array2.size()];
            for (int i = 0; i < array2.size(); i++) {
                q[i] = array2.get(i);
            }

            Solution solution = new Solution();
            ArrayList<Integer> v = solution.countMultiples(arr, q);

            for (int i = 0; i < v.size(); i++) {
                System.out.print(v.get(i) + " ");
            }
            System.out.println(); // New line after each test case output

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {

    public static ArrayList<Integer> countMultiples(int arr[], int q[]) {
        // Your code goes here
        int max = arr[0];
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        for(int i=0; i<q.length; i++) {
            max = Math.max(max,q[i]);
        }
        int count[] = new int[max+1];
        int ans[] = new int[max+1];
        
        for(int i=0; i<arr.length;i++) {
            count[arr[i]]++;
        }
        for(int i=1;i<=max;i++) {
            // System.out.println("k: " + k);
            for(int j=i; j<=max;j=j+i) {
                ans[i] += count[j];
            }
            // System.out.println("ans[k]: " + ans[k]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<q.length; i++) {
            res.add(ans[q[i]]);
        }
        return res;
    }
}