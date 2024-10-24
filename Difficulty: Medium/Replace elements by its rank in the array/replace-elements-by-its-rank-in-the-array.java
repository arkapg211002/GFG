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
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    
System.out.println("~");
}
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
   static int[] replaceWithRank(int arr[], int N) {
    int[] nums = Arrays.copyOf(arr,N);
    Arrays.sort(nums);
    int i=1,j=0;
    while(i<N){
        if(nums[i]!=nums[j]){
            j++;
            nums[j]=nums[i];
        }
        i++;
    }
    int[] rank = new int[N];
    for(i=0;i<N;i++){
        rank[i] = Arrays.binarySearch(nums,0,j+1,arr[i])+1;
    }
    return rank;
  }
}
     