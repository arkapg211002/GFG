//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.PriorityQueue; 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
	public static int minOperations(int a[], int n) 
	{ 
	    
	    int ans = 0;
	    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	    
	    for(int i = n - 1; i >= 0; i--){
	        if(!q.isEmpty() && q.peek() > a[i]){
	            ans += Math.abs(a[i] - q.peek());
	            q.poll();
	            q.add(a[i]);
	        }
	        q.add(a[i]);
	    }
	    
	    return ans;
	    
	} 
	
	/*
	arr = {3, 1, 2, 1}
	q = {1}
	
	*/
} 


//{ Driver Code Starts.
class GFG 
{ 
	
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);	
	    int t = sc.nextInt();
	    while (t > 0) {
	        int n;
	        n = sc.nextInt();
	        int[] a = new int[n];
	        for (int i = 0; i < n; i++) 
	        	a[i] = sc.nextInt();
	        Solution ob = new Solution();
	        System.out.println(ob.minOperations(a,n));
	        t--;
	    
System.out.println("~");
}
	}
}


// } Driver Code Ends