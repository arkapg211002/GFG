// https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if(arr.length == 1) return arr[0];  // If array contains 1 element
        int strlen = arr[0].length();
        for(int i=0;i<arr.length;i++) {
            strlen = Math.min(strlen, arr[i].length());
        }
        
        int index = -1;
        boolean flag = true;
        
        for(int i=0;i<strlen;i++) {
            for(int j=0;j<arr.length-1;j++) {
                if(arr[j].charAt(i) != arr[j+1].charAt(i)) {
                    index = i-1;
                    flag = false;
                }
            }
            if(flag == false) break;
        }
        
        if(index == -1) return "-1";
        String ans = "";
        for(int i=0;i<=index;i++) {
            ans += arr[0].charAt(i);
        }
        return ans;
    }
}
