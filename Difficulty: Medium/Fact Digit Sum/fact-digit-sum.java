//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int N = Integer.parseInt(s);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.FactDigit(N);
            for (Integer val: ans) 
                System.out.print(val);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    ArrayList<Integer> FactDigit(int N)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int fact[] = new int[10];
        fact[0]=1;
        
        for(int i=1;i<10;i++){
            fact[i]=i*fact[i-1];
        }
        
        //from back side 
        
        for(int i=9;i>0;i--){
            while(N>=fact[i]){
                N-=fact[i];
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}