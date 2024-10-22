//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            String S = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.CountPS(S, N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int CountPS(String s, int n) {
        int ans = 0;
       for(int i = 0; i<s.length();i++){
           ans += palindrome(i,i, s);
           ans += palindrome(i,i+1, s);
       } 
       return ans;
    }
    public int palindrome(int left, int right, String s){
        int count = 0;
        while(left>= 0 && right<s.length() && s.charAt(left--) == s.charAt(right++)){
            if(right-left>2)count++;
        }
        return count;
    }
}