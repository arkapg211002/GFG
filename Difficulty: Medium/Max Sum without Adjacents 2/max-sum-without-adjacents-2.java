//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            long res = obj.findMaxSum(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends







class Solution {
    int solveRec(int [] arr){
        int n = arr.length;
        if (n == 1) return arr[0];
        if (n == 2) return arr[0] + arr[1];
        int [] dp = new int[n + 1];
        Arrays.fill(dp,0);
        dp[n-1] = arr[n-1];
        dp[n-2] = arr[n-2] + arr[n-1];
        
        for(int index = n-3; index >= 0; index--){
        int take1 = arr[index] + dp[index + 2];
        int take2 = arr[index] + arr[index + 1] + dp[index + 3];
        int skip =  dp[index + 1];
        
        dp[index] = Math.max(skip,Math.max(take1,take2));
        }
        return dp[0];
    }
    public int findMaxSum(int arr[]) {
        return solveRec(arr);
    }
}