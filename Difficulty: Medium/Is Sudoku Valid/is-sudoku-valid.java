//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for (int i = 0; i < 81; i++) mat[i / 9][i % 9] = Integer.parseInt(s1[i]);

            Solution obj = new Solution();
            boolean res = obj.isValid(mat);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isValid(int mat[][]) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 9;i++)
        {
            for(int j = 0; j < 9;j++)
            {
                int num = mat[i][j];
                if(num !=0)
                {
                    if(!set.add(num+i) || !set.add(num+j) || !set.add(num+i/3+j/3))
                    {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}