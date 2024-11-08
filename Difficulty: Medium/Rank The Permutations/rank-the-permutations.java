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
            long ans = obj.findRank(str);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public long findRank(String S)
    {
        long[] factorial = factorial(S.length());
        long answer = 0;
        for (int i = 0; i < S.length(); i++) {
            long count = 0;
            for (int j = i + 1; j < S.length(); j++) {
                if (S.charAt(j) < S.charAt(i)) {
                    count++;
                }
            }
            answer += (count * factorial[S.length() - 1 - i]);
        }
        return answer + 1;
    }
    
    private long[] factorial(int n) {
        long[] factorial = new long[Math.max(n, 2)];
        factorial[0] = factorial[1] = 1l;
        for (int i = 2; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        return factorial;
        // Code here
    }
}