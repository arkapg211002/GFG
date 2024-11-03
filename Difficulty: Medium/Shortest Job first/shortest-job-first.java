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
      int ans = obj.solve(a);
      System.out.println(ans);
    
System.out.println("~");
}
  }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    static int solve(int[] arr){
        // time elapsed in executing all the process till now.
        int time = 0;
        // time waited to get executed.
        int waitingTime = 0;
        
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            waitingTime = waitingTime + time;
            time = time + arr[i];

        }
        return (waitingTime/arr.length);
  }
}
     