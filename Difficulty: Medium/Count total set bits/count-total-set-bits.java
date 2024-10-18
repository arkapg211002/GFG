//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
    
        // Your code here
        
        if(n==0) return 0;


         // Sum = x * 2^(x-1) + (n-2^x+1) + countSetBits(n-2^x)


        int x = calculateX(n);
        int countBitsTillTwoX = x * (1<<(x-1) ); // x * (2 to power x-1)
        int msb2xtoN = n - (1<<x) + 1;
        int rest = n - (1<<x); // solve for 3 for n = 11 ( 11 - 2 power 3) 
        
        return countBitsTillTwoX + msb2xtoN + countSetBits(rest);
        
    }
    
    public static int calculateX(int n){
        int x = 0;
        while( (1<<x) <= n ){ //  2 raise to power x is less than or equal to n
            x++;
        }
        return x-1;
    }
}

//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends