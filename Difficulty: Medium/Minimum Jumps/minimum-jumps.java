//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends






class Solution{
    static int minJumps(int[] arr){
        // your code here
        int jumps=0;
        int currmax=0;
        int maxpos=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(i > maxpos) return -1;
            if(maxpos >= n-1) return jumps;
            if(currmax < i+arr[i]) currmax  = i+arr[i];
            if(i == maxpos)
            {
                maxpos = currmax;
                jumps++;
            }
        }
        return jumps;
    }
}