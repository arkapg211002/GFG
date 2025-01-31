//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            // taking total count of elements
            String arr[] = sc.nextLine().trim().split(" ");
            Solution ob = new Solution();
            // calling TieBreak method and printing the result
            System.out.println(ob.TieBreak(arr));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public static String TieBreak(String arr[]) {
        
        TreeMap<String,Integer> tMap = new TreeMap<>();
        
        for(String s : arr)
        tMap.put(s, tMap.getOrDefault(s,0) + 1);
        
        String answer = tMap.firstKey();
        
        for(Map.Entry<String,Integer> entry : tMap.entrySet())
        {
            if(entry.getValue()>tMap.get(answer))
            answer = entry.getKey();
        }
        
        return answer;
        
    }
}