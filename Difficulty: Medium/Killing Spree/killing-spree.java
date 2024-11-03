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
            String input_line[] = read.readLine().trim().split("\\s+");
            long N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            long ans = ob.killinSpree(N);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}



// } Driver Code Ends




//User function Template for Java

class Solution{
    
    long killinSpree(long n)
    {
        long i=1;
       
        long j = (long)Math.sqrt(n);
        while(i<=j){
            long mid = i+(j-i)/2;
            long sum = (mid*(mid+1)*(2*mid+1))/6;
            if((n-sum)>=((mid+1)*(mid+1))){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return i;
    }
}