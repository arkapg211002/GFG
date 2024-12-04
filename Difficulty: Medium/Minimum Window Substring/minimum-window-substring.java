//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            if (ans.length() == 0) {
                System.out.println("\"\"");
            } else {
                System.out.println(ans);
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static String minWindow(String s, String t) {
        if(s.equals(t)) return s;
        int sLength = s.length();
        int tLength = t.length();
        
        int sIndex = 0, tIndex = 0;
        int start = 0, end = sLength-1;
        
        while(sIndex < sLength){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                tIndex++;
            }
            if(tIndex == tLength){
                int right = sIndex;
                tIndex--;
                while(tIndex >= 0){
                    if(s.charAt(sIndex) == t.charAt(tIndex)){
                        tIndex--;
                    }
                    sIndex--;
                }
                sIndex++;
                if(right-sIndex < end-start){
                    end = right;
                    start = sIndex;
                }
                tIndex = 0;
            }
            
            sIndex++;
        }
        int windowSize = end-start+1;
        if(windowSize == sLength) return "";
        return s.substring(start,start+windowSize);
    }
}