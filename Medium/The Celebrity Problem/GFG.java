// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int row = mat.length;
        int celebrity = -1;
        for(int i = 0;i<row;i++){
            int sum = 0;
            for(int j = 0;j<row;j++){
                sum += mat[i][j];
            }
            if(sum == 0) {
                celebrity = i; break;
            }
        }
        if(celebrity == -1) return -1;
        for(int i = 0;i<row;i++){
            if(celebrity == i) continue;
            if(mat[i][celebrity] != 1) return -1;
        }
        return celebrity;
    }
}
