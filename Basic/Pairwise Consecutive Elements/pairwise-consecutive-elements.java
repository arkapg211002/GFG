//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;

class elements
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            Stack<Integer> st = new Stack<Integer>();
            int n = sc.nextInt();
            int temp = 0;
            for(int i = 0; i < n; i++)
            {
                temp = sc.nextInt();
                st.push(temp);
            }
            GFG gfg = new GFG();
            if(gfg.pairWiseConsecutive(st) == true)
            System.out.println("Yes");
            else
            System.out.println("No");
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// your task is to complete the function
// function should return true/false or 1/0
class GFG
{
    public static boolean pairWiseConsecutive(Stack<Integer> st)
    {
        // Your code here
        if(st.size()==1) return true;
        int len=0;
        if(st.size()%2!=0) len=st.size()-1;
        else len=st.size();
        for(int i=0;i<len-1;i++)
        {
            if((st.get(i)-st.get(i+1)==1) || (st.get(i)-st.get(i+1)==-1))
                continue;
            else return false;
        }
        return true;
        
       
	}
}