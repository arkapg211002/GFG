//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public static int minSum(int arr[]) {
        if(arr.length < 3) return 0;
        if(arr.length == 3) return Math.min(arr[0], Math.min(arr[1], arr[2]));
        
        arr[3]+=Math.min(arr[0], Math.min(arr[1], arr[2]));
        for(int i=4;i<arr.length;i++) arr[i]+=Math.min(arr[i-1], Math.min(arr[i-2], arr[i-3]));
        int n = arr.length;
        return Math.min(arr[n-1], Math.min(arr[n-2], arr[n-3]));
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