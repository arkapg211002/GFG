//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            char board[][] = new char[3][3];
            for(int i = 0;i < 3;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    board[i][j] = a[j].charAt(0);
            }
            
            Solution ob = new Solution();
            List<Integer> ans = ob.findBestMove(board);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Play{
    int row;
    int column;
    Play(int row, int column){
        this.row = row;
        this.column = column;
    }
}
class Solution{
    static List<Integer> findBestMove(char board[][]){
        List<Integer> outputmove = new ArrayList<>();
        Play bestPlay = bestPlay(board);
        outputmove.add(bestPlay.row);
        outputmove.add(bestPlay.column);
        return outputmove;
    }
    static Play bestPlay(char board[][]){
        int bestValue = Integer.MIN_VALUE;
        Play bestPlay = new Play(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                if(board[row][col] == '_'){
                    board[row][col] = 'x';
                    int move = minimax(board, 0, false);
                    board[row][col] = '_';
                    if(move > bestValue){
                        bestPlay = new Play(row, col);
                        bestValue = move;
                    }
                }
            }
        }
        return bestPlay;
    }
    static int minimax(char board[][], int depth, boolean isMax){
        int points = evaluate(board);
        if(points == 10 || points == -10)
            return points;
        else if(!movesLeft(board))
            return 0;
        int best = Integer.MIN_VALUE;
        if(isMax){
            for(int row=0; row<3; row++){
                for(int col=0; col<3; col++){
                    if(board[row][col] == '_'){
                        board[row][col] = 'x';
                        best = Math.max(best, minimax(board, depth+1, false));
                        board[row][col] = '_';
                    }
                }
            }
            return best;
        }
        else{
            best = Integer.MAX_VALUE;
            for(int row=0; row<3; row++){
                for(int col=0; col<3; col++){
                    if(board[row][col] == '_'){
                        board[row][col] = 'o';
                        best = Math.min(best, minimax(board, depth+1, true));
                        board[row][col] = '_';
                    }
                }
            }
            return best;
        }
    }
    static int evaluate(char board[][]){
        for (int row = 0; row<3; row++) {
            if (board[row][0]==board[row][1] && board[row][1]==board[row][2]) {
                if (board[row][0]=='x')
                    return +10;
                else if (board[row][0]== 'o')
                    return -10;
            }
        }
        for (int col = 0; col<3; col++) {
            if (board[0][col]==board[1][col] && board[1][col]==board[2][col]) {
                if (board[0][col]=='x')
                    return +10;
                else if (board[0][col]=='o')
                    return -10;
            }
        }
        if (board[0][0]==board[1][1] && board[1][1]==board[2][2]) {
            if (board[0][0]== 'x')
                return +10;
            else if (board[0][0]== 'o')
                return -10;
        }
        if (board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
            if (board[0][2]== 'x')
                return +10;
            else if (board[0][2]== 'o')
                return -10;
        }
        return 0;
    }
    static boolean movesLeft(char board[][]){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(board[i][j] == '_')
                    return true;
        return false;
    }
}