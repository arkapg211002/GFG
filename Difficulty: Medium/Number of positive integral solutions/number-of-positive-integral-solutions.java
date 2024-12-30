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
                    Solution obj = new Solution();
                    System.out.println(obj.posIntSol(s));
                
System.out.println("~");
}
                
        }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    long posIntSol(String s)
   {
       //code here.
       int n = s.length(),unknowns = 1,k=0;
       long ans;
       for(int i = 0;i<n;i++){
           if(s.charAt(i)=='+')
               unknowns +=1;
           if(s.charAt(i)=='='){
               k = Integer.valueOf(s.substring(i+1));
               break;
           }
       }
       if(k<unknowns)
           ans = 0;
       else if(k==unknowns)
           ans = 1;
       else{
           k-= 1;          
           unknowns-=1;
           ans = 1;
           for(long i =k-unknowns+1;i<=k;i++)
               ans*=i;
           
           for(long i=1;i<=unknowns;i++)
               ans /=i;
           
       }
       return ans;
   }
}