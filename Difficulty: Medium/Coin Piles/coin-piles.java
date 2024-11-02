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
            String S1[] = read.readLine().split(" ");
            int N = Integer.parseInt(S1[0]);
            int K = Integer.parseInt(S1[1]);
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minSteps(A,N,K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends






//User function Template for Java


class Solution {
    static int minSteps(int[] A, int N, int K) {
        // code here
        Arrays.sort(A);
        int p[] = new int[N];
        int start = 0,ans = Integer.MAX_VALUE;
        p[0] = A[0];
        for(int i=1; i <N ; i++) {
          p[i] = p[i-1] + A[i];
        }
    
        for(int i=0; i<N ; i++) {
            int index = upper(A, K, i);
            
            if(i > 0 && A[i] != A[i - 1])
                start = p[i - 1];
            
            ans = Math.min(ans, start  + p[N-1] - p[index-1] - ((N -index) * (A[i] + K)));
            
        }
        return ans;
        
    
    }
    static int upper(int []a, int k, int index) {
        int val = a[index] + k;
        int i = index + 1,j = a.length - 1,ans = 0;
        
        while(i <= j){
            int mid = (i + j) / 2;
            if(a[mid] > val){
                ans = mid;
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        
        return ans == 0 ? a.length : ans;
    }
};