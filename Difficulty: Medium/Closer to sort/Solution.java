//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    long x = Long.parseLong(br.readLine().trim());
		    System.out.println(new Solution().closer(arr, n, x));
		
System.out.println("~");
}
	}
}
// } Driver Code Ends

//User function Template for Java

class Solution
{
  
    // n: size of array
    // x: element to find
    //Function to find index of element x in the array if it is present.
    static long closer(int arr[], int n, long x)
    {
        // add your code here
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(mid-1>=low && arr[mid-1]==x){
                return mid-1;
            }
            if(mid+1<=high && arr[mid+1]==x){
                return mid+1;
            }
            if(arr[mid]>x){
                high=mid-2;
            }
            else{
                low=mid+2;
            }
        }
        return -1;
    }
}

