// https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        // code here
         String str=n+"";
        int sum=0;
        for(char ch : str.toCharArray())
            sum+=Math.pow(ch-'0',3);
        return sum==n ? "Yes" : "No";
    }
}
