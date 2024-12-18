//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);

            boolean ans = obj.game(N, M);
            if (ans)
                System.out.println("Dolly");
            else
                System.out.println("Bunty");
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    boolean game(int a, int b) {
        // Code Here
        if(a == 0 & b == 0)
        return false;
        
        int n = Math.min(a,b);
        int m = Math.max(a,b);
        
        int k = m-n;
        
        return !(n == (int)Math.floor(k*1.618) && m == (int)Math.floor(k*1.618*1.618));
    }
}