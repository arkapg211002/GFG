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
            Long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.matchGame(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static int matchGame(Long N) {
        // code here
        int i=(int)(N%5);
        if(i>=1&&i<=4){
            return i;
        }
        return -1;
    }
}