//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            String s = input[0];
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.countOfSubstringWithKOnes(s, k));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    long countOfSubstringWithKOnes(String S, int K){
        //  code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0,1);
        int cntOne = 0;
        long res = 0;
        int n = S.length();
        
        for(int i = 0; i < n; i++)
        {
            cntOne += (S.charAt(i) - '0');
            
            if(cntOne >= K)
            {
                res += (long)map.getOrDefault((cntOne - K),0);
            }
            
            map.put(cntOne, map.getOrDefault(cntOne,0) + 1);
        }
        
        return res;
    }
}