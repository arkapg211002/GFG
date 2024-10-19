//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
static int mod=1_000_000_007;
    static long topDown(int n) {
        long p1=0,p2=1;
        for(int i=2;i<=n;i++){
            
            long res=(p1%mod+p2%mod)%mod;
            
            p1=p2;
            p2=res;
        }
        return p2;
    
    }

    static long bottomUp(int n) {
        // code here
        long arr[]=new long[n+1];
        Arrays.fill(arr,-1);
        return memo(n,arr);
    }
    static long memo(int n,long arr[]){
        if(n<=1){
            return n;
        }
        if(arr[n]!=-1){
            return arr[n];
        }
        return arr[n]=(memo(n-1,arr)%mod+memo(n-2,arr)%mod)%mod;
    }
}
