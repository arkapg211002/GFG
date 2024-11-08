//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            // Read the array elements from input
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            // Read the value of k
            int k = Integer.parseInt(read.readLine().trim());

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the maxDistinctNum function and print the result
            long ans = ob.maxDistinctNum(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public long maxDistinctNum(int[] arr, int k) {
        // Initialize a variable to store the maximum distinct numbers
        long res = 0;
        
        // Create a HashMap to store the frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Create a PriorityQueue to store the frequencies in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Calculate the frequency of each number and store it in the HashMap
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        // Add all the frequencies to the PriorityQueue
        for(int ele : map.values()){
            pq.offer(ele);
        }
        
        // Reduce the top 'k' frequencies by 1, ensuring they remain non-negative
        for(int i = 0 ; i < k ; i++) {
            int temp = pq.poll();
            if(temp > 1){
                pq.offer(temp - 1);
            }
        }
        
        // The size of the PriorityQueue now represents the maximum distinct numbers
        res = (long) (pq.size());
        return res;
    }
}