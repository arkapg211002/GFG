//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            long N = Long.parseLong(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.totalDivisors(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static long totalDivisors(long N){
        // code here
        int n = (int) N;
        int[] lp = new int[n + 1];
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            if (lp[i] == 0) {
                lp[i] = i;
                prime.add(i);
            }
            for (Integer pr : prime) {
                if (pr * i > n) {
                    break;
                }
                lp[pr * i] = pr;
                if (pr == lp[i]) {
                    break;
                }
            }
        }
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int t = i;
            while (t != 1) {
                ++cnt[lp[t]];
                t /= lp[t];
            }
        }
        long ans = 1;
        for (int i = 0; i <= n; ++i) {
            ans *= cnt[i] + 1;
        }
        return ans;
    }
}