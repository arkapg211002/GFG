//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.findOnce(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    int findOnce(int[] arr) {
        // Complete this function
        // handling edge case
        if(arr.length == 1) return arr[0];
        if(arr[0] != arr[1])    return arr[0];
        if(arr.length == 2){
            if(arr[0] != arr[arr[1]])
                return arr[0];
            else
                return 0; // this is as per given problem
                // that if no such value exists we will return 0
        }
        if(arr[arr.length -2] != arr[arr.length-1] ){
            if(arr[arr.length -2] != arr[arr.length-3] )
                return arr[arr.length - 2];
            else
                return arr[arr.length - 1];    
            
        }
            
            
        return helper(arr, 0, arr.length-1);
        
    }
    public int helper(int[] arr, int left, int right){
        while(left <= right){
            int mid = (left + right) / 2;
            if(mid != 0 && mid != arr.length -1 && 
                arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
                    return arr[mid];
            else{
                int valueOnLeft = helper(arr,left, mid -1);
                if(valueOnLeft != -1)
                    return valueOnLeft;
                int valueOnRight = helper(arr, mid+1, right);
                if(valueOnRight != -1)
                    return valueOnRight;
                else
                    break;
            }
        }
        return -1;
    }
}