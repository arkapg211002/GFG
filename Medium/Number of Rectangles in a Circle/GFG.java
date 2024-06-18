// https://www.geeksforgeeks.org/problems/rectangles-in-a-circle0457/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int count = 0;
        int dia = 2 * r;
        for(int i = 1; i < dia; i++){
            for(int j = 1; j < dia; j++){
                if(Math.pow(i,2) + Math.pow(j, 2) <= Math.pow(dia, 2)){
                    count++;
                }
            }
        }
        return count;
    }
};
