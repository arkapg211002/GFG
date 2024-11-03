//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        
out.println("~");
}
        out.flush();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int res =a;
        int noOfBitsInA=0;
        int noOfBitsInB=0;
        for(int i=31; i>=0; i--){
            if(((1<<i)&a) != 0){
                noOfBitsInA++;
            }
            if(((1<<i)&b) != 0){
                noOfBitsInB++;
            }
        }
        int remainingBits = noOfBitsInB - noOfBitsInA;
        for(int i=0; i<=31 && remainingBits != 0; i++){
            if(remainingBits > 0){
                if(((1<<i)&res) == 0){
                    res |= (1<<i);
                    remainingBits--;
                }
            } else {
                if(((1<<i)&res) != 0){
                    res ^= (1<<i);
                    remainingBits++;
                }
            }
        }
        return res;
    }
}