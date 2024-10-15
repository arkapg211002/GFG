//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int n, int arr[]) {
        int left=0, right=n-1;
        int[] count=new int[1];
        count[0]=0;
        mergeSort(arr,count,left,right);
        return count[0];
    }
    
    public static void mergeSort(int[] arr, int[] count, int left, int right) {
        if(left>=right)
            return;
        int mid=left+(right-left)/2;
        mergeSort(arr,count,left,mid);
        mergeSort(arr,count,mid+1,right);
        countPairs(arr,count,left,mid,right);
        merge(arr,count,left,mid,right);
    }
    
    public static void countPairs(int[] arr, int[] count, int left, int mid, int right) {
        int[] left_sub=new int[mid-left+1];
        int[] right_sub=new int[right-mid];
        int n=left_sub.length, m=right_sub.length, i=0, j=0, k, index=0;
        for(k=left;k<=mid;k++)
            left_sub[index++]=arr[k];
        index=0;
        for(k=mid+1;k<=right;k++)
            right_sub[index++]=arr[k];
        while(i<n && j<m) {
            if((long)left_sub[i]>(2*(long)right_sub[j])) {
                count[0]+=(n-i);
                j++;
            }
            else
                i++;
        }
    }
    
    public static void merge(int[] arr, int[] count, int left, int mid, int right) {
        int[] left_sub=new int[mid-left+1];
        int[] right_sub=new int[right-mid];
        int n=left_sub.length, m=right_sub.length, i=0, j=0, k, index=0;
        for(k=left;k<=mid;k++)
            left_sub[index++]=arr[k];
        index=0;
        for(k=mid+1;k<=right;k++)
            right_sub[index++]=arr[k];
        index=left;
        while(i<n && j<m) {
            if(left_sub[i]<=right_sub[j]) {
                arr[index++]=left_sub[i];
                i++;
            }
            else {
                arr[index++]=right_sub[j];
                j++;
            }
        }
        while(i<n) {
            arr[index++]=left_sub[i];
            i++;
        }
        while(j<m) {
            arr[index++]=right_sub[j];
            j++;
        }
    }
}

