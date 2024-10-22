//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr) {
	    Deque<Integer> stack1 = new ArrayDeque<>();
	    Deque<Integer> stack2 = new ArrayDeque<>();
	    int[] ans = new int[arr.length];
	    Arrays.fill(ans,Integer.MAX_VALUE);
	    
        for(int i = 0; i < arr.length; ++i) {
	        while(!stack1.isEmpty() && arr[i] < arr[stack1.peek()])
	            ans[stack1.pop()] = i; 
	        stack1.push(i);
	    }
	    
	    for(int i = arr.length - 1; i >= 0; --i) {
	        while(!stack2.isEmpty() && arr[i] < arr[stack2.peek()]) {
	            if(ans[stack2.peek()] == Integer.MAX_VALUE)
	                ans[stack2.pop()] = i; 
	            else if(Math.abs(stack2.peek() - i) < Math.abs(ans[stack2.peek()] - stack2.peek()))
	                ans[stack2.pop()] = i; 
	            else if(Math.abs(stack2.peek() - i) == Math.abs(ans[stack2.peek()] - stack2.peek())) {
	                if(arr[i] < arr[ans[stack2.peek()]]) 
	                    ans[stack2.pop()] = i; 
	                else if(arr[i] == arr[ans[stack2.peek()]] && i < ans[stack2.peek()])
	                    ans[stack2.pop()] = i;
	                else stack2.pop();
	            }
	            else stack2.pop();
	        }
	        stack2.push(i);
	    }
	    
	    for(int i = 0; i < arr.length; ++i)
	        if(ans[i] == Integer.MAX_VALUE) 
	            ans[i] = -1;
	    
	    return ans;
	}
}