//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            if(ob.geekNumber(N) == 1)
                System.out.println("Yes");
            else
                System.out.println("No");
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int geekNumber(int N){
        // code here
        for(int i=2;i<=Math.sqrt(N);i++){
            int count=0;
            while(N%i==0){
                count++;
                N=N/i;
            }
            if(count>1){
                return 0;
            }
        }
        return 1;
    }
}