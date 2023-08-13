//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution {
    static int maxLength(String S) {
        int n = S.length();
        int maxLength = 0;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize the stack with a dummy index
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    stack.push(i); // Update the starting index of the potential valid substring
                }
            }
        }
        
        return maxLength;
    }
}