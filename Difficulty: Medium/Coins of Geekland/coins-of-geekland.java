//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int a[][] = new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    int k = Integer.parseInt(sc.next());
		    Solution T = new Solution();
		    System.out.println(T.Maximum_Sum(a,n,k));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends




class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        // Your code goes here
          for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 0th index
                if(i == 0 && j == 0) {
                    mat[i][j] = mat[i][j];
                    
                } else if(i == 0) {
                    // 0th row
                    mat[i][j] += mat[i][j-1];
                    
                } else if(j == 0) {
                    // 0th col
                    mat[i][j] += mat[i-1][j];
                } else {
                    // 1th to N-1 th row and col
                    mat[i][j] = mat[i][j-1] + mat[i-1][j] - mat[i-1][j-1] + mat[i][j];
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        // calc max sum
        for(int i=K-1; i<N; i++) {
            for(int j=K-1; j<N; j++) {
                
                int val = mat[i][j];
                
                if(i-K >= 0) {
                    val -= mat[i-K][j];
                }
                
                if(j-K >= 0) {
                   val -= mat[i][j-K]; 
                }
                
                if((i-K >= 0) && (j-K >= 0)) {
                    val += mat[i-K][j-K];
                }
                
                max = Math.max(max, val);
            }
        }
        
        return max;
    }
}