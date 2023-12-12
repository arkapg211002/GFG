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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int maxGold(int n, int m, int a[][])
    {
        // code here
    	
		int row = a.length;
		int col = a[0].length;
		int dp[][] = new int[row][col];
		int max = 0;
		
		if(row == 1){
		    for(int i=0;i<col;i++){
		        max += a[0][i];
		    }
		   
		}
		else{
			for(int j=col-2;j>=0;j--) {
    			for(int i=0;i<row;i++) {
    				if(i==0) {
    					a[i][j] +=  Math.max(a[i][j+1],a[i+1][j+1]);
    				}else if(i==row-1) {
    					a[i][j] += Math.max(a[i][j+1], a[i-1][j+1]);
    				}else {
    					a[i][j] += Math.max(a[i][j+1], Math.max(a[i-1][j+1],a[i+1][j+1])); 		
    				}
    			}
    		}
    		for(int i=0;i<row;i++){
    		    if(max<a[i][0]){
    		        max = a[i][0];
    		    }
    		}
		}
    	return max;

    }
}