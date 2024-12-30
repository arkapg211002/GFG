//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);

            Solution obj = new Solution();
            int ans = obj.bellNumber(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends





class Solution {
    public int bellNumber(int n) {
        // Code Here
        int bell[][] = new int[n+1][n+1];
         bell[0][0] = 1;
        

        for (int i = 1; i <= n; i++) {
            
            bell[i][0] = bell[i - 1][i - 1];
            
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i][j - 1] + bell[i - 1][j - 1];
            }
        }
        
        
        return bell[n][0];
    }
};