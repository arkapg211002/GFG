//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.kThSmallestFactor(N, K));
        }
    }
}
// } Driver Code Ends




// User function Template for Java


class Solution {
    static int kThSmallestFactor(int n, int k) {
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i == 0){
                ans.add(i);
                if(n/i != i){
                    ans.add(n/i);
                }
            }
        }
        if(ans.size()<k) return -1;
        Collections.sort(ans);
        return ans.get(k-1);
    }
};