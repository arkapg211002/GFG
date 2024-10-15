//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int test = Integer.parseInt(br.readLine());
    	while(test-- > 0) {
    		String [] str = br.readLine().trim().split(" ");
    		int N = Integer.parseInt(str[0]);
    		int K = Integer.parseInt(str[1]);
    		int M = Integer.parseInt(str[2]);
    		int [] A = new int[N];
    		str = br.readLine().trim().split(" ");
    		for(int i = 0; i < N; i++)
    			A[i] = Integer.parseInt(str[i]);
    		Solution obj = new Solution();
    		boolean ans = obj.partitionArray(N, K, M, A);
    		if(ans){
                System.out.println("YES");
            }
            else{
            	System.out.println("NO");
            }
    	}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	boolean partitionArray(int N, int K, int M, int [] A){
        Arrays.sort(A);
        boolean dp[] = new boolean[N+1];
        dp[0] = true; // initial break before 0-element
        int i = 0;
        while (i+K-1 < N){
            if(dp[i] && i+K-1<N && A[i+K-1] <= A[i] + M) {
                int i0 = i;
                while(i+K-1<N && A[i+K-1] <= A[i0] + M ) {
                    dp[i+K] = true;
                    i++;
                }
            } else {
                i++;
            }
        }
        return dp[N];
    }
}