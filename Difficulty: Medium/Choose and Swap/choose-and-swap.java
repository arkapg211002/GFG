//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine().trim();

            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

   String chooseandswap(String str) {
         TreeSet<Character> set = new TreeSet();
         int len = str.length();
         for(int i=0; i<len; i++) {
            set.add(str.charAt(i));
         }
        for(int i=0; i<len && !set.isEmpty(); i++) {
             char ch = str.charAt(i);
             set.remove(ch);
             if(!set.isEmpty() && set.first()<ch) {
                char ch2 = set.first();
                str = str.replace(ch, '!').replace(ch2, ch).replace('!', ch2);
                return str;
             }
         }
         return str;
    }
}