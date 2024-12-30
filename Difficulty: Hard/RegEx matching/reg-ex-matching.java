//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String P = read.readLine();
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isPatternPresent(S,P));
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    static int isPatternPresent(String S, String P) {
        // code here
        if(P.charAt(0) == '^') {
            if(S.startsWith(P.substring(1))) {
                return 1;
            }
        }
        
        else if(P.charAt(P.length()-1) == '$') {
            if(S.endsWith(P.substring(0, P.length()-1))) {
                return 1;
            }
        }
        
        else if(S.contains(P)) {
            return 1;
        }
        
        return 0;
    }
};