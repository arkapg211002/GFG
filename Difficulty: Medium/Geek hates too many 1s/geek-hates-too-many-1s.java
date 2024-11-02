//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




class Solution {
    public static int noConseBits(int n) {
        //int max = Integer.MIN_VALUE;
        int num = n;
        for (int i = 29; i >= 0; i--) {
            int first = ((1 << i) & num) > 0 ? 1 : 0;
            int second = ((1 << (i + 1)) & num) > 0 ? 1 : 0;
            int third = ((1 << (i + 2)) & num) > 0 ? 1 : 0;
            if (first == 1 && second == 1 && third == 1) {
                num = num ^ (1 << i);
                //max = Math.max(max, num);
            }
        }
        return num;
    }
}    