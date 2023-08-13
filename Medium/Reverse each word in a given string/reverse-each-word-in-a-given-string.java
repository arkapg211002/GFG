//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        Stack<String> stack = new Stack();
        String ans="";
        int i=S.length()-1;
        StringBuilder temp = new StringBuilder();
        while(i>=0){
            if(S.charAt(i)!='.'){
                ans+=S.charAt(i);
            }
            else{
                if(!ans.equals("")){
                    stack.push(ans);
                    ans="";
                }
                stack.push(".");
            }
            i--;
            if(i==-1 && S.charAt(0)!='.'){
                stack.push(ans);
            }
        }
        while(!stack.isEmpty()){
            temp.append(stack.pop());
        }
        return temp.toString();
    }
    
}