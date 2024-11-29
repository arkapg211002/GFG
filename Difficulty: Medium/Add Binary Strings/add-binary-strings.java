//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        while (len1 < len2) {
            s1 = '0' + s1;
            len1++;
        }
        while (len2 < len1) {
            s2 = '0' + s2;
            len2++;
        }

        StringBuilder ans = new StringBuilder();
        boolean carry = false;

        for (int i = len1 - 1; i >= 0; i--) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            int sum = (ch1 - '0') + (ch2 - '0') + (carry ? 1 : 0);

            if (sum == 0) {
                ans.append('0');
                carry = false;
            } else if (sum == 1) {
                ans.append('1');
                carry = false;
            } else if (sum == 2) {
                ans.append('0');
                carry = true;
            } else if (sum == 3) {
                ans.append('1');
                carry = true;
            }
        }

        if (carry) {
            ans.append('1');
        }
        String result = ans.reverse().toString();
        return result.replaceFirst("^0+", ""); 
    }
}