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
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.firstDigit(arr,n));
            t--;
        }
    } 
} 
// } Driver Code Ends




//User function Template for Java

class Solution {
    static int firstDigit(int arr[], int n) { 
      double ans = 1.0;
        
        for(int x : arr){
            ans *= x;
            while(ans>10) ans/=10;
        }
        
        return (int)ans;
    } 
}