//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        int mod = (int)1e9+7;
        int a =0,b=0, c=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'a') a = (2*a%mod+1)%mod;
            if(s.charAt(i) == 'b') b = (2*b%mod+a)%mod;
            if(s.charAt(i) == 'c') c = (2*c%mod+b)%mod;
        }
        return c%mod;
    }
}