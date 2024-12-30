//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public static int countSub(int arr[]) {
        int[] dp = new int[10];
        
        for(int i=0;i<arr.length;i++) {
            dp[arr[i]]++;
            for(int j = arr[i]-1;j>=0;j--) dp[arr[i]]=(dp[arr[i]] + dp[j])%1000000007;
        }
        
        int response = 0;
        for(int i=0;i<10;i++) response=(response + dp[i])%1000000007;
        
        // for(int i=0;i<10;i++) System.out.println(dp[i]);
        return response;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
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
            int ans = obj.countSub(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends