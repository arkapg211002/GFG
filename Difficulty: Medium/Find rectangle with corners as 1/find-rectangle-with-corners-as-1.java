//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            Solution x = new Solution();
            if (x.ValidCorner(matrix))
                System.out.println("Yes");
            else
                System.out.println("No");
            t--;
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution { 
	static boolean ValidCorner(int matrix[][]) 
	{ 
	    int m = matrix.length;
	    int n = matrix[0].length;
	    
	    for(int i=0; i<m; i++)
	    {
	        for(int j=0; j<n; j++)
	        {
	            if(matrix[i][j]==1)
	            {
	                int r = i;
	                int c = j;
	                
	                for(int k=j+1; k<n; k++)
	                {
	                    if(matrix[r][k]==1)
	                    {
	                        for(int p=r+1; p<m; p++){
	                            if(matrix[p][c]==1 && matrix[p][k]==1){
	                                return true;
	                            }
	                        }
	                    }
	                }
	            }
	            
	        }
	    }
	    return false;
	}
}