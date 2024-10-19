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
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dirs  = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        
        Set<String> ans = new HashSet<>();
        for(String s: dictionary) {
            for(int i =0; i < n; i++) {
                for(int j =0; j < m; j++) {
                   if(s.charAt(0) == board[i][j] && visited[i][j] == 0) {
                       if(dfs(i, j, s, board, visited, 0)){
                           ans.add(s);
                       }
                   } 
                }
            }
        }
        int sz =  ans.size();
        String[] arr = new String[sz];
        int i =0;
        for(String s: ans){
            arr[i++] = s;
        }
        return arr;
    }
    
    public boolean dfs(int r, int c, String word, char[][] board, int[][] visited, int index) {
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] == 1 || word.charAt(index) != board[r][c]) {
            return false;
        }
        visited[r][c] = 1;
        boolean flag = false;
        for(int[] dir : dirs) {
            flag |= dfs(r + dir[0], c + dir[1], word, board, visited, index + 1);
        }
        visited[r][c] = 0;
        return flag;
    }
}
