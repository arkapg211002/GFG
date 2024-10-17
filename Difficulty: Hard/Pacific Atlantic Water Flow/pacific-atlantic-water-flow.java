//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().countCoordinates(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int i, int j, int[][] mat, boolean[][] visited, int prevHeight) {
        int n = mat.length;
        int m = mat[0].length;
        
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || mat[i][j] < prevHeight)
            return;
        
        visited[i][j] = true;
        
        // Move in all four directions
        dfs(i + 1, j, mat, visited, mat[i][j]);
        dfs(i - 1, j, mat, visited, mat[i][j]);
        dfs(i, j + 1, mat, visited, mat[i][j]);
        dfs(i, j - 1, mat, visited, mat[i][j]);
    }
    
    public int countCoordinates(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        
        int n = mat.length;
        int m = mat[0].length;
        
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        // DFS from Pacific Ocean (top and left borders)
        for (int i = 0; i < n; ++i) {
            dfs(i, 0, mat, pacific, mat[i][0]); // Left border (Pacific)
            dfs(i, m - 1, mat, atlantic, mat[i][m - 1]); // Right border (Atlantic)
        }
        
        for (int j = 0; j < m; ++j) {
            dfs(0, j, mat, pacific, mat[0][j]); // Top border (Pacific)
            dfs(n - 1, j, mat, atlantic, mat[n - 1][j]); // Bottom border (Atlantic)
        }
        
        // Count cells that can flow to both Pacific and Atlantic
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (pacific[i][j] && atlantic[i][j])
                    count++;
            }
        }
        
        return count;
    }
}
