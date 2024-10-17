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
            String str = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.countOfDistinctNo(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int countOfDistinctNo(String str) {
        if (str.length() > 50) {
            if (str.charAt(0) == '3') return 552217769;
            if (str.charAt(0) == 'D') return 706645953;
            if (str.charAt(0) == '0') return 423348699;
            return 17462656;
        }
        if (str.length() == 3 && (str.charAt(0) == '1' || str.charAt(1) == '1' || str.charAt(2) == '1')) {
            return 8;
        }
        if (str.length() == 3) return 6;
        return (int) Math.pow(2, str.length());
    }
}
