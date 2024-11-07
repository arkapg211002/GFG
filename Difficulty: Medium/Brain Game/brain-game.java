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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.brainGame(nums);
            if(ans)
                System.out.println("A");
            else 
                System.out.println("B");     
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution
{
    public boolean isPrime(int n){
        for (int i=2; i*i <= n; i++) {
            if (n %i == 0) return false;
        }
        return true;
    }
    int primeFactor(int n) 
	{
	    int ans = 0;
        int num =n;
        for(int i=2; i<=num/2; i++)
        {
            while(n%i == 0)
            {
                ans++;
                n/= i;
            }
        }
        return ans;
    }
	

    public boolean brainGame(int[] nums)
    {
        int ans=0;
        for(int num:nums){
            if(!isPrime(num)) ans=ans^(primeFactor(num)-1);
        }
        return ans!=0;
    }
}