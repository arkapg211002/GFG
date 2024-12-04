//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countBits(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    static int countBits(int n) {
        int count = 0;
        for(int i=0;i<=n;i++){
            int num = i;
            while(num >0){
                if((num & 1)==1){
                    count = count+1;
                }
                
            num=num >> 1;
            }
            
        }
        return count;
    }
}