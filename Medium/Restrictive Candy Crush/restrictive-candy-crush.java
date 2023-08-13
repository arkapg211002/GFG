//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;
import java.io.*;

class FastReader{ 
	BufferedReader br; 
	StringTokenizer st; 

	public FastReader(){ 
		br = new BufferedReader(new InputStreamReader(System.in)); 
	} 

	String next(){ 
		while (st == null || !st.hasMoreElements()){ 
			try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
		} 
		return st.nextToken(); 
	} 

	String nextLine(){ 
		String str = ""; 
		try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
		return str; 
	} 
} 

class Gfg
{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            out.println(T.reduced_String(k, s));
        }
        out.flush();
    }
}

// } Driver Code Ends




//User function Template for Java

/*
    Note: Use StringBuilder/StringBuffer class for String concatenation(if any).
    While using String class, on each concatenation a new copy of the string is created, so that 
    the overall complexity is O(n^2) . Fortunately in Java we could solve this with a StringBuffer/StringBuffer, 
    which has O(1) complexity for each append.
*/

class Solution
{
    public static String reduced_String(int k, String s)
    {
    Stack<Character> st = new Stack<>();
        if(k==1){
            return "";
        }
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            int count =1;
            if(st.size()==0){
                st.push(ch);
            }
            else if(st.peek()==ch){
                while(st.size()>0 && st.peek()==ch &&count<=k){
                    st.pop();
                    count++;
                }
                if(count!=k){
                    for(int j=0;j<count;j++){
                        st.push(ch);
                    }
                }
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder ans= new StringBuilder();
        while(st.size()>0){
            ans.append(st.pop());
        }
        return ans.reverse().toString();   
        
      
        
    }
}