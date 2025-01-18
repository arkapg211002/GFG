//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    int n = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.countDivisibleSubseq(s,n));
                }
        }
}    
// } Driver Code Ends




class Solution{

	public int countDivisibleSubseq(String s,int N) 
	{ 
	    // Your code goes here
	    int [] dp=new int[N];
	    int mod=(int)Math.pow(10,9)+7;
	    for(int i=0;i<s.length();i++)
	    {
	        int number=s.charAt(i)-48;
	        int [] temp=new int[N];
	        temp[number%N]++;
	        for(int j=0;j<N;j++)
	        {
	           temp[j]=(temp[j]+dp[j])%mod;
	           int remainder=(j*10+number)%N;
	           temp[remainder]= (temp[remainder]%mod+dp[j]%mod)%mod;
	        }
	        
	        dp=temp;
	    }
	    
	    return dp[0];
	} 
}