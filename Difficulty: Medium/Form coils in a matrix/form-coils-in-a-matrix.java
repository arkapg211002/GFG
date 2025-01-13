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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            int[][] ptr = ob.formCoils(n);
            
            for(int i=0; i<2; i++)
            {
                for(int j=0; j<ptr[i].length; j++)
                {
                    System.out.print(ptr[i][j] + " ");
                }
                System.out.println();
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int[][] formCoils(int n) {
        // code here
        int m=8*n*n;
        int[][] mat=new int[2][m];
        mat[0][0]=8*n*n+2*n;
        int ele=mat[0][0],dir=1,step=2,i=1;
        while(i<m){
            for(int j=0;j<step;j++){
                ele=mat[0][i++]=(ele-4*n*dir);
                if(i>=m)
                    break;
            }
            if(i>=m)
                break;
            for(int j=0;j<step;j++){
                ele=mat[0][i++]=ele+dir;
                if(i>=m)
                    break;
            }
            dir*=-1;
            step+=2;
        }
        for(int k=0;k<m;k++){
            mat[1][k]=16*n*n+1-mat[0][k];
        }
        return mat;
    }
}