//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        // Step 1: Compute the longest prefix-suffix (LPS) array for the pattern
        int[] lps = computeLPSArray(pat);
        // Step 2: Perform the KMP search
        int i = 0;  // Index for txt
        int j = 0;  // Index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                // Pattern found, add the index (1-based indexing)
                res.add(i - j );
                j = lps[j - 1];  // Use the LPS array to avoid unnecessary comparisons
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];  // Use the LPS array to skip characters
                } else {
                    i++;
                }
            }
        }
        return res;
        
    }
    
    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;
        
        // Build the LPS array
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];  // Try the previous longest prefix suffix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}