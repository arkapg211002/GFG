//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        char ch[]=s.toCharArray();
        int count[]=new int[26];
        
        for(int i=0;i<ch.length;i++)
        count[ch[i]-48-49]++;

        for(int i=0;i<ch.length;i++)
        {
            if(count[ch[i]-48-49]==1)
            return ch[i];
        }
       
        return '$';
    }
}