//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static long largestPrimeFactor(long N) {
        // code here
        long LF = 1;
        while(N%2 == 0){   //for even
            LF = 2;
            N = N/2;
        }
        
        for(long i = 3;i<=Math.sqrt(N);i +=2){
            while(N%i == 0){
                LF = i;
                N = N/i;
            }
        }
        
        if (N > 2) {
            LF = N;
        }
        
        return LF;
    }
}