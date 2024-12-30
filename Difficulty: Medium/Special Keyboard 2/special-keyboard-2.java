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
            int res = obj.findminoperation(n);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends





class Solution {
    public static int findminoperation(int n) {
        // code here
        int res=0;
        int factor=2;
        while(n>1)
        {
            while(n%factor==0)
            {
                res+=factor;
                n/=factor;
            }
            factor++;
        }
        return res;
    }
}
          
