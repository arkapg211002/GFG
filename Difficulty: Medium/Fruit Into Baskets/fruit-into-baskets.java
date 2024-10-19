//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {

// Map to store the fruit type and their count in the current window 
      Map<Integer, Integer> map = new HashMap();
      int n = arr.length;
      int left = 0, right = 0, max = 0;
     for( right = 0; right< n; right++ ){
         map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

// If there are more than two types of fruits, shrink the window
         while( map.size() > 2){
             map.put(arr[left], map.get(arr[left])-1 );
             if( map.get(arr[left]) == 0){
                 map.remove(arr[left]);
             }
             left++;
         }

// Update the maximum number of fruits we can pick 
         max = Math.max(max, right - left + 1);
     }
      return max;
    }
}