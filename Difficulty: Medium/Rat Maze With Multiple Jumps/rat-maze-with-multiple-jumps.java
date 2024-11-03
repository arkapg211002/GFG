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
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int[][] ans = ob.ShortestDistance(matrix);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution
{
    public int[][] ShortestDistance(int[][] mat)
    {
        int[][] visited = new int[mat.length][mat[0].length];
        int[][] invalid = new int[1][1];
        invalid[0][0] = -1;
        return shortestDistance(mat, 0, 0, visited) ?visited : invalid;
    }
    public boolean shortestDistance(int[][] mat, int r, int c, int[][] visited) {
        if(r == mat.length-1 && c == mat[0].length-1) {
            visited[r][c] = 1;
            return true;
        }
        if(!validPath(mat, r, c)) {
            return false;
        }
        
        visited[r][c] = 1;
        for(int i = 0;i<mat[r][c];i++) {
            if(validPath(mat, r, c+1+i) && shortestDistance(mat, r, c+1+i, visited)) {
                return true;
            }
             if(validPath(mat, r+1+i, c) && shortestDistance(mat, r+1+i, c, visited)) {
                return true;
            }
        }
        visited[r][c] = 0;
        return false;
    }
    boolean validPath(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        return r >= 0 && c >= 0 && r < n && c < m && (mat[r][c] > 0 || (r == n-1 && c == m-1));
    }
}