//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.superPrimes(n));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution {
    int superPrimes(int n) {
        int[] v = new int[n + 1];
        int x = 1, count = 0;

        for (int i = 2; i <= n; i++) {
            if (v[i] == 0) {
                if (2 + x == i) {
                    count++;
                }
                x = i;
                for (int j = i + i; j <= n; j += i) {
                    v[j] = 1;
                }
            }
        }

        return count;
    }
}