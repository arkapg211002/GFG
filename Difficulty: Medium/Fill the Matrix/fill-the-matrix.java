//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends

//User function Template for Java

class Solution
{
    static int[] r = {-1, 0, 1, 0};
    static int[] c = {0, -1, 0, 1};
    
	public static int minIteration(int n, int m, int x, int y){
		//code here
		
		int[][] matrix = new int[n][m];
		
		matrix[x-1][y-1] = 1;
		
		int count = 0;
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[]{x-1, y-1});
		
		while(!q.isEmpty()) {
		    int size = q.size();
		    
		    for(int itr = 0; itr< size; itr++) {
		        int[] curr = q.remove();
    		    
    		    for(int i = 0; i< 4; i++) {
    		        int newx = curr[0] + r[i];
    		        int newy = curr[1] + c[i];
    		        
    		        if(newx < n && newy < m && newx >= 0 && newy >= 0 && matrix[newx][newy] == 0) {
    		            matrix[newx][newy] = 1;
    		            q.add(new int[]{newx, newy});
    		        }
    		    }
		    }
		    
		    count++;
		}
		
		return count - 1;
		
	}
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        
System.out.println("~");
}
        
    }
}
// } Driver Code Ends