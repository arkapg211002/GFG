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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.permutationCoeff(n,k);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends



//User function Template for Java



class Solution {
   // int mod = (int)10^9 + 7;// Correct modulo value


    public int permutationCoeff(int n, int k) {
        // Compute the result using helper function
      int mod = (int)(1e9 + 7);
        long p = 1;
        
        for(int i = 0; i < k; i++){
            p = (p*(n-i))%mod;
        }
        
        return (int)p;
    }
}