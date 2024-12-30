//{ Driver Code Starts

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java// User function Template for Java

class Solution {
    public long countPairs(int[] arr) {
        long two = 0, gTwo  =0;
        
        for(Integer n: arr){
            if(n==2)two++;
            if(n>2)gTwo++;
        }
        
        
       
        return two*gTwo + (gTwo*(gTwo - 1)/2);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline after the integer input

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution solution = new Solution();
            System.out.println(solution.countPairs(arr));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends