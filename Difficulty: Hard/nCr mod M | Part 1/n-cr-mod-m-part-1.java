//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            long n = Long.parseLong(s[0]);
            long r = Long.parseLong(s[1]);
            Solution obj = new Solution();
            int ans = obj.nCr(n, r);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static final int MOD = 1000003;

    public int nCr(long n, long r) {
        if (r > n) {
            return 0;
        }
        
        long[] fact = new long[MOD];
        long[] invFact = new long[MOD];

        // Compute all factorials % MOD
        fact[0] = 1;
        for (int i = 1; i < MOD; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // Compute inverses using Fermat's Little Theorem
        invFact[MOD - 1] = power(fact[MOD - 1], MOD - 2, MOD);
        for (int i = MOD - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        // Apply Lucas's theorem for large n
        long result = 1;
        while (n > 0 && r > 0) {
            int ni = (int)(n % MOD);
            int ri = (int)(r % MOD);
            if (ri > ni) {
                return 0;
            }
            result = result * fact[ni] % MOD * invFact[ri] % MOD * invFact[ni - ri] % MOD;
            n /= MOD;
            r /= MOD;
        }
        return (int) result;
    }

    // Function to compute a^b % MOD using binary exponentiation
    private long power(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}


