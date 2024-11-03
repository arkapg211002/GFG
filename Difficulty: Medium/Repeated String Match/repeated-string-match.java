//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A, B));
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static int repeatedStringMatch(String a, String b) {
        // Your code goes here
        String res = "";
        while(res.length() < b.length()) {
            res = res + a;
        }
        res = res + res;
        int in = res.indexOf(b);
        if(in == -1) {
            return -1;
        }
        int tot = in + b.length();
        if(tot % a.length() != 0) {
            return (in + b.length())/a.length() + 1;
        }
        return (in + b.length())/a.length();
    }
}