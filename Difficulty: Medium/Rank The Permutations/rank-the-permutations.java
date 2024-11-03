//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.rank(S));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int rank(String s) {
        int m = 1000003;
        
        int fact[] = new int[26];
        fact[0] =1;
        for (int i=1; i<fact.length; i++) {
            fact[i]  = (fact[i-1] * i) % m;     
        }
        
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            int c = 0;
            for (int j = i+1; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) return 0;
                if (s.charAt(i) > s.charAt(j)) c++;
            }
            res = (res % m + (fact[s.length()-i-1] % m * c % m) % m) % m;
        }
        
        return res+1;
    }
}