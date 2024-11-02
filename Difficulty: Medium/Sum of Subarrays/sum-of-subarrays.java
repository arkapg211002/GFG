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
            long res = obj.subarraySum(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    public long subarraySum(int[] arr) {
        // code here
        
        int n= arr.length;
        long freq =0 ;
        long sum =0;
        long mod = 1000000007;
        
        for(int i = 0; i<n; i++)
        {
            freq = (long) (i+1) * (n-i) % mod;
            sum =  (sum + freq * arr[i]) % mod;
        }
        
        return sum;
    }
}