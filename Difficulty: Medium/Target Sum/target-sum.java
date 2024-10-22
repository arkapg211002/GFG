//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(N,A, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int find(int n,int[] arr,int t){
        if(n==-1) return t==0?1:0;
        return find(n-1,arr,t-arr[n])+find(n-1,arr,t+arr[n]);
    }
    static int findTargetSumWays( int n, int[] a ,int t) {
        // code here
        return find(n-1,a,t);
    }
};