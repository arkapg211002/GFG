//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String text = sc.next();
            String pat = sc.next();
            Solution obj = new Solution();
            int res = obj.findMatching(text, pat);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int findMatching(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();
        
        if(n==0)
        {
            return 0;
        }
        
        
        for(int i=0;i<=m-n;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i + j) != s2.charAt(j)){
                    break;
                }
                if(j == n-1){
                    return i;
                }
            }
        }
        
        return -1;
        
        // Code here
    }
}