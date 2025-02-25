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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getCount(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int getCount(int N) {
        // code here
        int ans=0;
        for(int i=2;i*(i-1)/2<N;++i){
            if((N-i*(i-1)/2)%i==0){
                ans++;
            }
        }
        return ans;
    }
};