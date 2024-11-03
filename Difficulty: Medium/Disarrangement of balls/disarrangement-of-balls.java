//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.disarrange(N));
        }
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution{
    private static int MOD = 1000000007;
    
    static long disarrange(int n) {

      if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }


        long prev2 = 0, prev1 = 1;
        long ans;
        for (long i = 3; i <= n; i++) {
            ans = (((i - 1) % MOD) * ((prev2 % MOD) + (prev1 % MOD)))%MOD;
            prev2 = prev1;
            prev1 = ans;
        }


        return prev1%MOD;
    }
    

}