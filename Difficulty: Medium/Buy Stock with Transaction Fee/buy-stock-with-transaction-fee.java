//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            long ans = ob.maximumProfit(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public long maximumProfit(int arr[], int k) {
        // Code here
        int profit = 0;
        int buyPrice = arr[0]; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < buyPrice) {
                buyPrice = arr[i];  
            }
            else if (arr[i] > buyPrice + k) {  
                profit += arr[i] - buyPrice - k;  
                buyPrice = arr[i] - k;  
            }
        }

        return profit;
    }
}