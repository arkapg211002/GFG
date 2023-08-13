//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    {
        // your code here    
        Stack<Character>st=new Stack<>();
        char arr[]=s.toCharArray();
        int left=0;
        for(char c: arr)
        {
            if(c=='{') st.push(c);
            else
            {
                if(!st.isEmpty()) st.pop();
                else
                {
                    st.push('{');
                    left+=1;
                }
            }
        }
        //System.out.println(left+" "+st.size());
        if(st.size()%2!=0) return -1;
        return left+(st.size()/2);
        
    }
}