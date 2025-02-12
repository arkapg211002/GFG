//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Solution sln = new Solution();
            System.out.println(sln.findMin(a, b));

            System.out.println("~");
        }
    }
}


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int findMin(int a, int b) {
        // Your code here
        int min = Integer.MAX_VALUE;
        try{
            
            if(a+b < min){
                min = a+b;
            }
            
            if(a-b < min){
                min = a-b;
            }
            
            if(a*b < min){
                min = a*b;
            }
            
            if(a/b < min){
                min = a/b;
            }
            
        }
        catch(Exception e){
            
            
        }
        
        return min;
        
    }
}



//{ Driver Code Starts.
// } Driver Code Ends
