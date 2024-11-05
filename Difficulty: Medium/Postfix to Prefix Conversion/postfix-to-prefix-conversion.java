//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int n=post_exp.length();
        Stack<String> s=new Stack<>();
        String ans="";
        for(int i=0;i<n;i++){
            char c=post_exp.charAt(i);
            if(Character.isLetterOrDigit(c)) s.push(c+"");
            else {
                String top1=s.pop();
                String top2=s.pop();
                String temp=""+c+top2+top1+"";
                s.push(temp);
            }
        }
        return s.pop();
    }
}