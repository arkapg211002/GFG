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
            String a[] = in.readLine().trim().split("\\s+");
            long L = Long.parseLong(a[0]);
            long R = Long.parseLong(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.primeProduct(L, R));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long primeProduct(long L, long R){
        // code here
        
        boolean isPrime[] = new boolean[(int)(R-L+1)];
        
        int sqrt = (int)Math.sqrt(R);
        ArrayList<Integer> primes = sieve(sqrt);
        int MOD = 1000000007;
        
        for(int prime : primes){
            int multiple = (int)Math.ceil((L*1.0)/prime);
            if(multiple==1) multiple++;
            int sIdx = multiple * prime - (int)L;

            for(int i = sIdx ; i<isPrime.length ; i+=prime){ // for marking true to every multiples of a prime no
                isPrime[i] = true;
            }
                
        }
        
         // false - prime , true - non prime
        long prod = 1L;
        
        for(int i=0;i<isPrime.length;i++){
            if(isPrime[i]==false && i+L!=1){
                
                long sum = (L + i);
          
                prod = (prod * sum)%MOD;
            }
        }
        
        return prod;
        
    }
    
    static ArrayList<Integer> sieve(int n){
        
        
         // false - prime , true - non prime
        boolean isPrime[] = new boolean[n+1];
        
        for(int i = 2;i*i<=n;i++){
            if(isPrime[i]==false){
                for(int j = 2 * i ; j<n ; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 2;i<=n;i++){
            if(isPrime[i]==false){
                ans.add(i);
            }
        }
        return ans;
    }


}