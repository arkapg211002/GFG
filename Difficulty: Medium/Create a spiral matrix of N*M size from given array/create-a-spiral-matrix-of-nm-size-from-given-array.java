//{ Driver Code Starts
import java.util.*;

class Array {
    public static void input(int[] A, int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
}

class Matrix {
    public static void input(int[][] A, int n, int m) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = sc.nextInt();
            }
        }
    }

    public static void print(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("~");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n * m];
            for (int i = 0; i < n * m; i++) {
                arr[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            int[][] res = obj.spiralFill(n, m, arr);

            Matrix.print(res);
        }
        sc.close(); // Close the scanner after use
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int[][] spiralFill(int n, int m, int[] arr) {
        // code here
        int[][] mat = new int[n][m];
        
        int left=0;
        int top=0;
        int right = m-1;
        int bottom = n-1;
        
        
        int k=0;
        
        while(k<(n*m)){
            
            for(int x=left;x<=right;x++){
                mat[top][x] = arr[k];
                k++;
            }
            top++;
            for(int x=top;x<=bottom;x++){
                mat[x][right] = arr[k];
                k++;
            }
            right--;
            
            if(top<=bottom){
            for(int x=right;x>=left;x--){
                mat[bottom][x] = arr[k];
                k++;
            }
            bottom--;
            }
            if(left<=right){
            for(int x=bottom;x>=top;x--){
                mat[x][left] = arr[k];
                k++;
            }
            left++;
            }
        }
        return mat;
    }
}