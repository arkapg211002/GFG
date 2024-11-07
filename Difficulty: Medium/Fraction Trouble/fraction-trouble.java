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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int d  =Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int[] ans = ob.LargestFraction(n, d);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public static int[]  LargestFraction(int n, int d) {
        int bestNumerator =0, bestDenominator=1;
        for (int q = 10000; q >= 2 ; q--) {
            int p = (n * q - 1)/d;

            if (p * bestDenominator >= q * bestNumerator) {
                bestNumerator = p;
                bestDenominator = q;
            }
        }

        int gcd = gcd(bestNumerator, bestDenominator);
        return new int[] {bestNumerator/ gcd, bestDenominator/gcd};
    }
    
     public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a %b );
    }
}