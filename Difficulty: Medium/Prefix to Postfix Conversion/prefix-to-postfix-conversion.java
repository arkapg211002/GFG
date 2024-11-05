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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    
    // prefix To Infix function
    
    static String preToInfix(String pre_exp) {
        
        int index=pre_exp.length()-1;
        StringBuilder result=new StringBuilder();
        Stack<String> st=new Stack<>();
        
        for(int i=index;i>=0;i--){
            
            char ch = pre_exp.charAt(i);
            
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
            ||(ch>='0' && ch<='9')){
                String myString = String.valueOf(ch);  
                st.push(myString);
            }
            
            if((ch=='^') || (ch=='/') || (ch=='*') ||(ch=='+') ||(ch=='-')){
                 
                 String first=st.pop();
                 String Second=st.pop();
                 String res="("+first+ch+Second+")";
                 st.push(res);
                
            }
            
            
            
            
        } //End of for loop
        
        return st.pop();
    }
    
    // infix to postFix
    
     static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
   
    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If character is an operand, add it to the output
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ||(ch>='0' && ch<='9')) {
                result.append(ch);
            }
            // If character is '(', push it to the stack
            else if (ch == '(') {
                st.push(ch);
            }
            // If character is ')', pop until '(' is found
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop(); // pop '('
            }
            // An operator is encountered
            else {
                while (!st.isEmpty() && prec(ch) <= prec(st.peek())) {
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        // Pop all the operators from the stack
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.toString();
    }
    
    static String preToPost(String pre_exp) {
        String EXP= preToInfix(pre_exp);
        EXP=infixToPostfix(EXP);
        return EXP;
    }
}
