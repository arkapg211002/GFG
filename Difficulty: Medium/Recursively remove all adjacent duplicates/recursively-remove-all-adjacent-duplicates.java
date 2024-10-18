//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String S = br.readLine();
            Solution ob = new Solution();
            String ans = ob.rremove(S).trim();
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String rremove(String s) {
        // code here
        return helper(new StringBuilder(s),s.length()).toString();
    }
    
    StringBuilder helper(StringBuilder sb,int len){
        char prev = sb.charAt(0);
        int prevIndex = 0;
        
        int i;
        for (i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) == prev) {
                continue;
            } else if (i - prevIndex > 1) {
                sb.replace(prevIndex, i, "");
                i = prevIndex-1;
                if (i < 0){ 
                    prev = sb.charAt(0);
                    prevIndex = 0;
                    i = 0;
                }
            } else {
                prevIndex = i;
                prev = sb.charAt(i);
            }
        }
        
        if (i - prevIndex > 1)
            sb.replace(prevIndex, i, "");
        
        if (sb.length()==0 || sb.length() == len) {
            return sb;
        }
    
        return helper(sb, sb.length());
    }
}