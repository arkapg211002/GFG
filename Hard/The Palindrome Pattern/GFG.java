// https://www.geeksforgeeks.org/problems/the-palindrome-pattern3900/1

//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean palin=true;
            int l=0,r=n-1;
            while(l<r){
                if(arr[i][l++]!=arr[i][r--]){
                    palin=false;
                    break;
                }
            }
            if(palin) return i+" "+"R";
        }
        for(int j=0;j<n;j++){
            boolean palin=true;
            int l=0,r=n-1;
            while(l<r){
                if(arr[l++][j]!=arr[r--][j]){
                    palin=false;
                    break;
                }
            }
            if(palin) return j+" "+"C";
        }
        return "-1";
    }
}
