//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
     static void heapify(int[] arr,int index,int n){
        int largest=index;
        
        int left=2*index+1;
        int right=2*index+2;
        if(left<n && arr[left]>arr[largest])largest=left;
        if(right<n && arr[right]>arr[largest])largest=right;
        
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            heapify(arr,largest,n);
        }
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
       
       for(int i=(N/2-1);i>=0;i--){
           heapify(arr,i,N);
          
       }
}
}
     