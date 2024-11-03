//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int maxWater(int[] arr) {
        // code here
        int n = arr.length, l = 0, r = n-1, s = 0, lmax = 0, rmax = 0;
        while(l<=r){
            if(lmax < rmax){
                s += Math.max(0, lmax - arr[l]);
                lmax = Math.max(lmax, arr[l]);
                l++;
            } else {
                s += Math.max(0, Math.min(lmax, rmax) - arr[r]);
                rmax = Math.max(rmax, arr[r]);
                r--;
            }
            //System.out.println(s);
        }
        return s;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
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

            Solution obj = new Solution();
            int res = obj.maxWater(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends