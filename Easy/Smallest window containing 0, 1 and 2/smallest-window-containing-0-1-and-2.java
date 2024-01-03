//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int a=-999;
        int b=-999;
        int n0=-1;
        int n1=-1;
        int n2=-1;
        int length=Integer.MAX_VALUE;
        for(int i=0;i<S.length();i++)
        {
           if(S.charAt(i)=='0')     n0=i;
           if(S.charAt(i)=='1')     n1=i;
           if(S.charAt(i)=='2')     n2=i;
           if(n1!=-1 && n2!=-1 && n0!=-1)
           {
               a=Math.min(n0,Math.min(n1,n2));
               b=Math.max(n0,Math.max(n1,n2));
               length=Math.min(length,(b-a+1));
           }
        }
        if(a!=-999&&b!=-999)    return length;
        return -1;
    }
};
