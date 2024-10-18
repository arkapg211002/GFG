//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean isReadable(int[] arr, int mid , int m){
        int count = 1;
        int i = 0;
        int sum = 0;
        while(i < arr.length){
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }else{
                count++;
                sum = arr[i];
            }
            i++;
        }
        return count <= m;
    }
    public static long findPages(int n, int[] arr, int m) {
        if(m > arr.length) return -1;
        
        int max = 0;
        int sum = 0;
        for(int i : arr){
            if(i > max) max = i;
            sum += i;
        }
        
        int low = max;
        int high = sum;
        long res = -1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isReadable(arr,mid,m)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }
        
        return res;
    }
};