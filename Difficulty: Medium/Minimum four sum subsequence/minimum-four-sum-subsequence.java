//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
/*Complete the function below*/
class Solution {
    public static int minSum(int arr[]) {
        int n=arr.length;
        
        if(n<=4){
            return min(arr, 0, n);
        }
        
        int[] dp = new int[n]; 
        
        dp[0] = arr[0]; 
        dp[1] = arr[1]; 
        dp[2] = arr[2]; 
        dp[3] = arr[3]; 
  
        for (int i = 4; i < n; i++){
            dp[i] = arr[i] + Math.min(Math.min(dp[i - 1], dp[i - 2]), 
                         Math.min(dp[i - 3], dp[i - 4])); 
        }
        
        return Math.min(Math.min(dp[n - 1], dp[n - 2]), 
                        Math.min(dp[n - 4], dp[n - 3])); 
            
    }
    
    public static int min(int arr[], int start, int end){
        int min=Integer.MAX_VALUE;
        
        for(int i=start; i<end; i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        
        return min;
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
            int ans = obj.minSum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends