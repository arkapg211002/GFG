//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends





class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String s)
    {
        // add your code here
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='[' || ch=='{' || ch=='(') st.push(ch);
            //System.out.println(st);
            if(ch==']' || ch=='}' || ch==')')
            {
                if(st.isEmpty()==true) return false;
                else
                {
                    char temp=st.peek();
                    st.pop();
                    if(match(temp,ch)==0) return false;
                }
                
            }
        }
        if(st.isEmpty()==true) return true;
        else return false;
    }
    static int match(char a, char b)
    {
        if(a=='[' && b==']') return 1;
        else if(a=='{' && b=='}') return 1;
        else if(a=='(' && b==')') return 1;
        else return 0;
    }
}
