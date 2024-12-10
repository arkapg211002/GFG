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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getSpecialNumber(n));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends




//User function Template for Java


class Solution{
public long getSpecialNumber(int N){
        if (N == 1) return 0;  
        if (N == 2) return 1;  

        String ok="";
        N--;
        while(N>0){
            ok=(N%6)+""+ok;
            N/=6;
        }
        long ans=Long.valueOf(ok);
        return ans;
    }
}
    
