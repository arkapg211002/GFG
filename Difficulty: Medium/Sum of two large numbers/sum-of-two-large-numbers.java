//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        // code here
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        int i = X.length()-1, j = Y.length()-1;
        
        while(i >= 0 && j >= 0)
        {
            int n = X.charAt(i) - '0';
            int m = Y.charAt(j) - '0';
            Integer sum = (n + m + carry) % 10;
            sb.insert(0,sum.toString());
            if(n + m + carry > 9)
                carry = 1;
            else
                carry = 0;
                
            if(i == 0 && j == 0 && carry == 1)
            {
                sb.insert(0,"1");
            }
            i--;j--;
        }
        
        while(i >= 0)
        {
            if(carry == 1)
            {
               int n = X.charAt(i) - '0';
               Integer sum = (n+1) % 10;
               if(n+1 > 9)
               {
                   carry = 1;
               }
               else
               {
                   carry = 0;
               }
               sb.insert(0,sum.toString());
            }
            else
            {
                sb.insert(0,X.charAt(i));
            }
            if(i == 0 && carry == 1)
            {
                sb.insert(0,"1");
            }
            i--;
        }
        
        while(j >= 0)
        {
            if(carry == 1)
            {
               int n = Y.charAt(j) - '0';
               Integer sum = (n+1)%10;
               if(n+1> 9)
               {
                   carry = 1;
               }
               else
               {
                   carry = 0;
               }
               sb.insert(0,sum.toString());
            }
            else
            {
                sb.insert(0,Y.charAt(j));
            }
            if(j == 0 && carry == 1)
            {
                sb.insert(0,"1");
            }
            j--;
        }
        
        int k = 0;
        while(sb.length() != 1 && sb.charAt(k) == '0')
        {
            sb.delete(k,k+1);
        }
        
        return sb.toString();
    }
}