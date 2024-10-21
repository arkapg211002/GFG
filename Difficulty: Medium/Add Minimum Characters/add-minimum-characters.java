//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		String s1 = new StringBuilder(str).reverse().toString();
		
		String s = str+"#"+s1;
		
		int[] lps = new int[s.length()];
		
		common(lps, s);
		
		return str.length()-lps[s.length()-1];
		
		
	}
	public static void common(int[] lps, String s){
	    int i = 1, n = s.length(), len = 0;
	    
	    while(i < n){
	        if(s.charAt(i) == s.charAt(len)){
	            len++;
	            lps[i] = len;
	            i++;
	        }
	        else{
	            if(len == 0){
	                i++;
	            }
	            else{
	                len = lps[len-1];
	            }
	        }
	    }
	}
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends