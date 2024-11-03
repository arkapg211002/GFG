//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    int n=sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.convert(s,n));
                
System.out.println("~");
}
                
        }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    String convert(String s, int n)
    {
        //code here
        
        if(n ==1) return s;
        
        char [] charstring = s.toCharArray();
        
        String [] rows = new String [n];
        
        int curr_step=0;
        int step=0;
        for (int i = 0; i < n; i++) {
            rows[i] = "";
        }
        for(int i = 0;i<s.length();i++){
            
            if(curr_step==0){
              step=1;  
            }
            else if(curr_step == n-1){
                step = -1;
            }
           
           rows[curr_step] =rows[curr_step] + charstring[i];
           curr_step+=step;
            
        }
        
        return String.join("",rows);
        
        
        
    }
}