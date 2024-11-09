//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    boolean dfs(int row, int col, int index, char[][] board, String word, boolean[][] vis) {
        if (index == word.length()) {
            return true; // Found the word
        }

        int n = board.length;
        int m = board[0].length;

        // Directions for 8 possible movements (up, down, left, right, and diagonals)
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        vis[row][col] = true; // Mark current cell as visited

        for (int i = 0; i < 8; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            // Check bounds and if the next cell matches the next character in the word
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && board[nrow][ncol] == word.charAt(index)) {
                if (dfs(nrow, ncol, index + 1, board, word, vis)) {
                    return true; // Word found
                }
            }
        }
        vis[row][col] = false; // Backtrack
        return false; // Word not found
    }

    public String[] wordBoggle(char[][] board, String[] dictionary) {
        Set<String> ans = new HashSet<>();
        int n = board.length;
        int m = board[0].length;

        for (String word : dictionary) {
            boolean found = false; // Flag to check if the word is found
            boolean[][] vis = new boolean[n][m]; // Visited array

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == word.charAt(0) && !vis[i][j]) { // Start DFS if first character matches
                        if (dfs(i, j, 1, board, word, vis)) {
                            ans.add(word); // Add word if found
                            found = true;
                            break; // No need to continue searching for this word
                        }
                    }
                }
                if (found) {
                    break; // Exit the outer loop if word is found
                }
            }
        }

        return ans.toArray(new String[0]); // Convert set to array and return
    }

}