//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            String s[] = new String[n];
            for(int i=0;i<n;i++)
            {
                s[i] = sc.next();
            }
            Solution T = new Solution();
            System.out.println(T.lcp(s,n));
        
System.out.println("~");
}
        
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public String lcp(String arr[],int n)
    {
        // Write your code here
        int k=0;
        Arrays.sort(arr);
        String first = arr[0];
        String last = arr[arr.length - 1];
        int minLength
            = Math.min(first.length(), last.length());
        int i=0;
        while (i < minLength
               && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        if(i==0)
        return "-1";
        else
        return first.substring(0, i);
    }
}