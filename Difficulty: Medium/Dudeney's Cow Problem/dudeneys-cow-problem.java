//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.totalAnimal(N);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int totalAnimal(int n) {
        // code here
        return fibo(n+1);
    }
    public int fibo(int n)
    {
       int a=0,b=1,c=0;
       for(int i=2;i<=n;i++){
           c=a+b;
           a=b;
           b=c;
       }
       return c;
    }
}