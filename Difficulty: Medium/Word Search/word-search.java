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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word){
        
        
        int n= board.length;
        int m = board[0].length;
        
        boolean[][] visited= new boolean[n+1][m+1];
        
        for(int i = 0 ;i < n; i++){
            for(int j= 0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean check = f(0,i,j,board,word,visited);
                    if(check){
                        return true;
                    }
                }
            }
        }
        
        return false;
        
    }
    
    public boolean f(int ind,int row,int col,char[][] board,String woard,boolean[][] visited){
        
        if(ind == woard.length()){
            return true;
        }
        
        if(row < 0|| col < 0|| row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != woard.charAt(ind)){
            return false;
        }
        
        visited[row][col] = true;
        boolean down = f(ind+1,row+1,col,board,woard,visited);
        boolean up = f(ind+1,row-1,col,board,woard,visited);
        boolean right = f(ind+1,row,col+1,board,woard,visited);
        boolean left = f(ind+1,row,col-1,board,woard,visited);
        if(down || up || right || left){
            return  true;
        }
        visited[row][col] = false;
        return false;
    }
}