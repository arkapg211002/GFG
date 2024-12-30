//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            s = s.toUpperCase();
            int ans = obj.characterReplacement(s, k);
            System.out.println(ans);

            System.out.println("~");
        }
    }

    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static int characterReplacement(String s, int k) {
       int[] freq = new int[26]; // Array to store character frequencies
        int maxFreq = 0; // Track the maximum frequency of any character in the window
        int maxLength = 0; // Track the maximum length of the valid substring
        int left = 0; // Left pointer of the sliding window

        for (int right = 0; right < s.length(); right++) {
            // Update the frequency of the current character
            freq[s.charAt(right) - 'A']++;
            
            // Update maxFreq to track the most frequent character in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Check if the current window is valid
            while ((right - left + 1) - maxFreq > k) {
                // If invalid, shrink the window by moving the left pointer
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the maximum length of the valid substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}