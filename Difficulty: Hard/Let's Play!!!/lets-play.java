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
            String s[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String arr[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(arr[i]);
            int x = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.isSuperSimilar(n, m, mat, x));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int isSuperSimilar(int rows, int cols, int[][] matrix, int noofRot) {
        noofRot = noofRot % cols;
        
        if(cols == 1 || noofRot == 0) {
            return 1;
        }
        
        for(int i = 0;i < rows;i++) {
            int start, end, ptr = 0;
            
            if(i % 2 == 0) {
                start = noofRot;
            } else {
                start = cols - noofRot;
            }
            end = start - 1;
            
            while(ptr < cols) {
                if(matrix[i][ptr] != matrix[i][start]) {
                    return 0;
                }
                
                start++;
                ptr++;
                
                if(start == end) {
                    break;
                }
                start = start % cols;
            }
        }
        
        return 1;
    }
}

