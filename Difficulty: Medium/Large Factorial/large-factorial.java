//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(str[i]);
            }

            Solution ob = new Solution();
            
            long res[] = ob.factorial(a,n);
            
            for (int i=0; i<n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long[] factorial(long a[], int n) {
        // code here
        long max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,a[i]);
        }
        long ans[] = new long[(int)max+1];
        ans[0] = 1;
        for(int i=1;i<=max;i++){
            ans[i] = (ans[i-1]*i)%1000000007;
        }
        long r[] = new long[n];
        for(int i=0;i<n;i++){
            r[i] = ans[(int)a[i]]%1000000007;
        }
        return r;
    }
}