//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

// } Driver Code Ends

//User function Template for Java

class Solution 
{ 
	static int maxCandy(int height[], int n) 
	{ 
	    // Your code goes here
	    int ans = 0;
	    int i = 0, j = n - 1;
	    while(i < j){
	        int res = Math.min(height[i] , height[j]) * (j - i - 1);
	        ans = Math.max(ans, res);
	        if(height[i] < height[j])
	            i++;
	        else
	            j--;
	    }
	    return ans;
	}
}


//{ Driver Code Starts.
class GFG{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int height[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                height[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCandy(height,n));
            t--;
        
System.out.println("~");
}
	} 
} 


// } Driver Code Ends