//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.countZero(n));
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution{
    static int zeroUpto(int digits)
{
   
   int first = (int) ((Math.pow(10,digits)-1)/9);
   int second = (int) ((Math.pow(9,digits)-1)/8);
   return 9 * (first - second);
}
 

static int toInt(char c)
{
   return (int)(c)-48;
}
 
   static int countZero(int N){
       //complete the function here
       String num=String.valueOf(N);
       int k = num.length();
 
   
   int total = zeroUpto(k-1);
 
  
   int non_zero = 0;
   for (int i=0; i<num.length(); i++)
   {
       
       if (num.charAt(i) == '0')
       {
           non_zero--;
           break;
       }
 
       
       non_zero += (toInt(num.charAt(i))-1) * (Math.pow(9,k-1-i));
   }
 
   int no = 0, remaining = 0,calculatedUpto=0;
 
   
   for (int i=0; i<num.length(); i++)
   {
       no = no*10 + (toInt(num.charAt(i)));
       if (i != 0)
           calculatedUpto = calculatedUpto*10 + 9;
   }
   remaining = no-calculatedUpto;
 
   
   int ans = zeroUpto(k-1) + (remaining-non_zero-1);
   return ans;
   }
}