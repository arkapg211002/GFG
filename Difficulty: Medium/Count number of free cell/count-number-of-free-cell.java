//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine().trim());
        while(T>0)
        {
            String s[]=in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[k][2];
            for(int i=0; i<k; i++){
                s=in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            Solution g = new Solution();
            long[] res = g.countZero(n,k,a);
            
            for(int i=0; i<res.length; i++){
                out.print(res[i]+" ");
            }
            out.println();
            T--;
        
out.println("~");
}
        out.close();
    }
}
// } Driver Code Ends



//User function Template for Java

class Solution {
    long[] countZero(int N, int K, int[][] arr) {
        boolean[] filledRows = new boolean[N + 1]; // Track filled rows
        boolean[] filledColumns = new boolean[N + 1]; // Track filled columns
        
        int filledRowCount = 0; // Count of filled rows
        int filledColumnCount = 0; // Count of filled columns
        
        long[] result = new long[K]; // Result array to store remaining zeros after each operation
        
        for (int i = 0; i < K; i++) {
            int r = arr[i][0]; // Row index
            int c = arr[i][1]; // Column index
            
            // Mark row as filled if it wasn't already
            if (!filledRows[r]) {
                filledRows[r] = true;
                filledRowCount++;
            }
            
            // Mark column as filled if it wasn't already
            if (!filledColumns[c]) {
                filledColumns[c] = true;
                filledColumnCount++;
            }
            
            // Calculate remaining zeros
            long remainingZeros = (long) N * N 
                                  - (long) filledRowCount * N 
                                  - (long) filledColumnCount * N 
                                  + (long) filledRowCount * filledColumnCount;
            
            // Store the result
            result[i] = remainingZeros;
        }
        
        return result;
    }
}
