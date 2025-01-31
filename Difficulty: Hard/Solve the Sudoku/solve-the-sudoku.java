//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java
class Index{
    int row,col;
    public Index(int r,int c){
        this.row=r;
        this.col=c;
    }
}
class Solution {
    public static Index FreeCell(int[][] board,int SIZE){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(board[i][j]==0){
                    return (new Index(i,j));
                }
            }
        }
        return null;
    }
    static void solveSudoku(int[][] mat) {
        int SIZE=mat.length;
        int R=mat.length;
        int C=mat[0].length;
        int[] rflag=new int[SIZE];
        int[] cflag=new int[SIZE];
        int[] subgrid=new int[SIZE];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]!=0){
                    int subgrid_i=(i/3)*3+j/3;
                    rflag[i] |=(1<<(mat[i][j]));
                    cflag[j] |=(1<<(mat[i][j]));
                    subgrid[subgrid_i] |=(1<<(mat[i][j]));
                }
            }
        }
        solve(mat,rflag,cflag,subgrid,SIZE);
    }
    public static boolean solve(int[][] board,int[] rflag,int[] cflag,int[] subgrid,int SIZE){
        Index cell=FreeCell(board,SIZE);
        if(cell==null){
            return true;
        }
        int smi=(cell.row/3)*3+(cell.col)/3;
        for(int i=1;i<=9;i++){
            if ((rflag[cell.row] & (1<<i))==0 && (cflag[cell.col] & (1<<i))==0 && (subgrid[smi] & (1<<i))==0){
                board[cell.row][cell.col]=i;
                rflag[cell.row] |=(1<<i);
                cflag[cell.col] |=(1<<i);
                subgrid[smi] |=(1<<i);
                if(solve(board,rflag,cflag,subgrid,SIZE)){
                    return true;
                }
                board[cell.row][cell.col]=0;
                rflag[cell.row] ^=(1<<i);
                cflag[cell.col] ^=(1<<i);
                subgrid[smi] ^=(1<<i);
            }
        }
        return false;
    }
}