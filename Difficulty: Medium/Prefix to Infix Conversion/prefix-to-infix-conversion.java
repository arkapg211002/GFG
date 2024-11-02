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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    static String preToInfix(String exp) {
        // code here
        int n=exp.length();
        int i=n-1;
        Stack<String> st = new Stack<>();
        while(i>=0){
            char ch=exp.charAt(i);
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                st.push(ch+"");
            }
            else{
                String t1=st.peek();
                st.pop();
                String t2=st.peek();
                st.pop();
                String ans="("+t1+ch+t2+")";
                st.push(ans);
            }
           i--;
        }
         return st.pop();
        
    }
}