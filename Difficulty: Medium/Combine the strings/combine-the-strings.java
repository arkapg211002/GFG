//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            String[] s = new String[n];
            for (int i = 0; i < n; i++) s[i] = sc.next();

            Solution obj = new Solution();
            System.out.println(obj.combine(n, s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public int combine(int n, String s[]) {
        // code here
        int bCount = 0;
        int rCount = 0;
        int rbCount = 0;
        int brCount = 0;
        for(int i=0;i<s.length;i++){
            if(s[i].charAt(0) == 'R' && s[i].charAt(s[i].length()-1) == 'R'){
                rCount ++;
            } else if(s[i].charAt(0) == 'B' && s[i].charAt(s[i].length()-1) == 'B'){
                bCount ++;
            } else if(s[i].charAt(0) == 'B' && s[i].charAt(s[i].length()-1) == 'R'){
                brCount ++;
            } else{
                rbCount ++;
            }
        }
        if(rbCount+brCount == 0){
            if(Math.max(rCount, bCount) == 1)
                return 0;
            return Math.max(rCount, bCount)*s[0].length();
        }
        if(rbCount == 0 || brCount == 0){
            if(rCount == 0 && bCount == 0)
                return 0;
            return (rCount+ bCount+1)*s[0].length();
        }
        int ans = rCount+bCount+ 2*Math.min(rbCount, brCount);
        if(rbCount != brCount)
            ans++;
        return ans*s[0].length();
    }
}