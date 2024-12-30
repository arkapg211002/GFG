//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 
import java.lang.*;

// } Driver Code Ends
//User function Template for Java
class Solution 
{ 
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
	    // Your code goes here 
	    
	    
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]==b[0])?b[1]-a[1]:b[0]-a[0]);
	    for(int i =0; i<k; i++)
	    {
	        pq.offer(new int[]{Math.abs(arr[i]-x),arr[i]});
	    }
	    for(int i =k; i<n; i++)
	    {
	        pq.offer(new int[]{Math.abs(arr[i]-x),arr[i]});
	        pq.poll();
	    }
	    ArrayList<Integer> ls = new ArrayList<>();
	    while(!pq.isEmpty())
	    {
	        int tmp[] = pq.poll();
	        ls.add(tmp[1]);
	    }
	    Collections.sort(ls);
	    return ls;
	}
}


//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int x = sc.nextInt();
        	int k = sc.nextInt();
        	int arr[] = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		arr[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.Kclosest(arr,n,x,k);

            for (int i=0; i<ans.size(); i++) 
        	    System.out.print(ans.get(i)+" "); 
            System.out.println();
            t--;
        
System.out.println("~");
}
    } 
} 




// } Driver Code Ends