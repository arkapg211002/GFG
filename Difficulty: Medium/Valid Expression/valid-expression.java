//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution 
{ 
    boolean valid(String s) 
    { 
        // code here
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='{')
            st.push('}');
            else if(c=='(')
            st.push(')');
            else if(c=='[')
            st.push(']');
            else{
                if(st.isEmpty() || st.pop()!=c)
                return false;
            }
        }
        return st.isEmpty();
    }
} 