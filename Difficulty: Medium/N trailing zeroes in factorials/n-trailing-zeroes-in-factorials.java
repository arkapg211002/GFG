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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            Solution ob = new Solution();
            int ans = ob.countZeroes(N);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends




//User function Template for Java

class Solution{
    
    int countZeroes(int n) {
        int i = 1, cnt = 0;
        while (true) {
            if (fact(i) == n) {
                cnt++;
            } else if (fact(i) > n) {
                break;
            }
            i++;
        }
        return cnt;
    }

    int fact(int M) {
        int res = 0;
        for (int i = 5; i <= M; i = i * 5) {
            res = res + M / i;
        }
        return res;
    }
}
