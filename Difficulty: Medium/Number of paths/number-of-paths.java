//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    
 
static int modVal = 1000000000 + 7;
 
static long numberOfPaths(int M, int N) {
    return nCr(M+N-2, M-1);
}
 
// Function to calculate nCr % modVal
static long nCr(int n, int r) {
    long res = 1;
    
    // If r is more than n/2, then it's equivalent to n-r
    if(r > n - r) r = n - r;
    
    for(int i = 0; i < r; i++) {
        res = (res * (n - i)) % modVal;
        res = (res * modInverse(i + 1)) % modVal;
    }
    
    return res;
}
 
// Function to calculate x raised to the power y using binary exponentiation
static long power(long x, long y) {
    long res = 1;
    x = x % modVal;
    while(y > 0) {
        if((y & 1) == 1) res = (res * x) % modVal;
        y = y >> 1;
        x = (x * x) % modVal;
    }
    return res;
}
 
// Function to find modular inverse of a under modulo modVal using Fermat's Little Theorem
static long modInverse(int a) {
    return power(a, modVal - 2);
}
}