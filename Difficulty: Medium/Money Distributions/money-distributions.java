//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.totalWays(n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    public long power(long a,long b , long mod){
        
        long ans = 1L;
        while(b>0){
            if((b&1)!=0 ){
                ans = (ans*a)%mod;
            }
            a = (a*a)%mod;
            b>>=1;
        }
        return ans;
    }
    
    public int nCr(int N,int R){
        
        long res= 1L;
        //long deno=1L;
        if(R > N-R){
            R = N-R;
        }
        long mod =(long) 1e9+7;
        for(int i=0;i<R;i++){
            
            res = (res *(N-i))%mod;
            res= res*power(i+1 , mod-2 ,mod)%mod;
            
        }
        
        return (int)res;
    }
    public int totalWays(int N, int K)
    {
        if(K > N)return 0;
        if(K==N)return 1;
        
        return nCr(N-1,K-1);
        
    }
}