//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ;i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        
System.out.println("~");
}
    } 
} 

// } Driver Code Ends




//User function Template for Java

class Solution 
{ 
    
    public static int binary(int a[], int key,int n){
        
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]+key>0)
            high=mid-1;
            else
            low=mid+1;
        }
        
        return high;
        
    }
    
    static long ValidPair(int a[], int n) 
	{ 
	    long ans=0;
	 Arrays.sort(a);
	 int ind=-1;
	 int tmp=0;
	 for(int i=0;i<n;i++){
	     if(a[i]>=0){
	     ind=i;
	     break;
	     }
	 }
	 if(ind==-1)
	 return -1;
	 
	 for(int i=0;i<ind;i++){
	     
	     int j=binary(a,a[i],n);
	     ans=ans+(n-(j+1));
	     
	 }
	 
	 for(int i=ind;i<n;i++){
	     ans=ans+(n-(i+1));
	 }
	 
	 return ans;
	 
	 // Your code goes here
	}
} 