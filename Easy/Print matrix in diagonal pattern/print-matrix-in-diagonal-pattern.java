//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] arr) {
        int n = arr.length;
        if (n == 1) return new int[]{arr[0][0]};
        int[] ans = new int[n*n];
        int k = 0;
        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                int row = i, col = 0;
                while (row >= 0){
                    ans[k++] = arr[row][col];
                    row--;
                    col++;
                }
            } else {
                int row = 0, col = i;
                while (col >= 0){
                    ans[k++] = arr[row][col];
                    col--;
                    row++;
                }
            }
        }
        for (int i = 1; i < n; i++){
            if (n % 2 == 1){
                if (i % 2 == 0){
                    int row = n - 1, col = i;
                    while (col <= n-1){
                        ans[k++] = arr[row][col];
                        row--;
                        col++;
                    }
                } else {
                    int col = n - 1, row = i;
                    while (row <= n-1){
                        ans[k++] = arr[row][col];
                        col--;
                        row++;
                    }
                }
            } else {
                if (i % 2 == 1){
                    int row = n - 1, col = i;
                    while (col <= n-1){
                        ans[k++] = arr[row][col];
                        row--;
                        col++;
                    }
                } else {
                    int col = n - 1, row = i;
                    while (row <= n-1){
                        ans[k++] = arr[row][col];
                        col--;
                        row++;
                    }
                }
            }
        }
        
        return ans;
    }
}