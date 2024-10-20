//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int a[], int n, int m) {
        // code here
        int beg = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                if (m > 0) {
                    m--;
                    result = Math.max(result, i - beg + 1); 
                } else {
                    while (a[beg] != 0) {
                        beg++;
                    }
                    beg++; 
                }
            } else {
                result = Math.max(result, i - beg + 1); 
            }
        }
        return result; 
    }
}