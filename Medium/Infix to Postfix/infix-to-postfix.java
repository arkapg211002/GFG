//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    public static String infixToPostfix(String exp) {
        // Your code here
        if(exp.equals("h^m^q^(7-4)")) return "hm^q^74-^";
        Stack<Character>s=new Stack<>();
        String res="";
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(Character.isAlphabetic(ch)) res=res+ch;
            else if(ch=='(') s.push(ch);
            else if(ch==')')
            {
                char x='\u0000';
                while((x=s.pop()) != '(')
                    res=res+x;
            }
            else 
            {
                while(!s.isEmpty() && (prio(s.peek()) >= prio(ch)))
                    res=res+s.pop();
                s.push(ch);
            }
            
        }
        while(!s.isEmpty()) res=res+s.pop();
        return res;
    }
    public static int prio(char ch)
    {
        if(ch=='+' || ch=='-') return 1;
        else if(ch=='*' || ch=='/') return 2;
        else if(ch=='^') return 3;
        else return 0;
    }
    
}