//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int n = Integer.parseInt(element[0]);

            Solution obj = new Solution();
            ArrayList<Integer> ans;
            ans = obj.fact(n);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static ArrayList<Integer> fact(int n) {
        // Complete the function
        ArrayList<Integer> list = new ArrayList<>();
        float v = 1;
        int count=  0;
        for(int i = 2;i<=n  ;i++)
        {
            v=v*i ;
            while(v>=10)
            {
                v=v/10;
                count++;
            }
        }
        list.add((int)v);list.add(count);
        return list;
    }
}