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
            System.out.println(ob.optimalKeys(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int optimalKeys(int N) {
        if (N <= 6)
            return N;

        int screen[] = new int[N];
        int i, j;

        for (i = 1; i <= 6; i++)
            screen[i - 1] = i;

        for (i = 7; i <= N; i++) {
            screen[i - 1] = 0;

            for (j = i - 3; j >= 1; j--) {
                int cur = (i - j - 1) * screen[j - 1];

                if (cur > screen[i - 1])
                    screen[i - 1] = cur;
            }
        }

        return screen[N - 1];
    }
}