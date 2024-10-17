//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int S = Integer.parseInt(input_line[1]);
            int X = Integer.parseInt(input_line[2]);
            String ans = ob.toughProblem(N, S, X);
            System.out.println(ans);
        }
    }
}





// } Driver Code Ends


//User function Template for Java


class Solution{
    String toughProblem(int n, int s, int x){
        if(s<x) return "No";
        if((s%2)!=(x%2)) return "No";
        if((n==1)&&(s==x)) return "Yes";
        if((n==1)&&(s!=x)) return "No";
        if(n>=3) return "Yes";
        return "No";    
    }
}
