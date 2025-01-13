//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            long n = Long.parseLong(in.readLine());
            
            Solution ob = new Solution();
            if(ob.largePrime(n) == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
     static int largePrime(long n){
        if(n<=3) return 0;
        int count=0;
        long max=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            int temp=0;
            while(n%i==0){
               temp++;
               max=i;
               count=temp;
               n/=i;
            }
        }
        
        if(n>1){
            
           if(n>max){
               max=n;
               count=1;
           }
            
            
        }
        //System.out.println(hm.get(max)+" "+ max);
        return (count!=1)?1:0;
        
        
    }
}