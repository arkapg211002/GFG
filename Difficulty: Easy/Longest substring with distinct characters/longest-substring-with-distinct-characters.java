//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public int longestUniqueSubstr(String s) {
        int a[] = new int[26];
        int maxi = 0;
        for(int i = 0, j = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            a[c - 'a']++;
            while(true)
            {
                boolean flag = true;
                for(int p = 0; p < 26; p++)
                {
                    if(a[p] > 1)
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    break;
                }
                a[s.charAt(j++) - 'a']--;
            }
            maxi = Math.max(maxi, (i - j + 1));
        }
        return maxi;
    }
}