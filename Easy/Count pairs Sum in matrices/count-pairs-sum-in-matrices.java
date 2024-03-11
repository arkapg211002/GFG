//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        int i1 = 0, j1 = 0, i2 = n - 1, j2 = n - 1, pairs = 0;
	   
	   while(i1 < n && i2 >= 0) {
	       int t1 = mat1[i1][j1], t2 = mat2[i2][j2];
	       if(t1 + t2 <= x) {
	           if(t1 + t2 == x) 
	               pairs++;
	           
	           j1++;
	           if(j1 == n) {
	               j1 = 0;
	               i1++;
	           }
	       } else {
	           j2--;
	           if(j2 == -1) {
	               j2 = n - 1;
	               i2--;
	           }
	       }
	   }
	   
	   return pairs;
    }
}