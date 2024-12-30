//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int find(int N){
        // code here
        int highestPowerOf2 = Integer.highestOneBit(N);
        int L = N - highestPowerOf2;
        return 2*L+1;
    }
}


//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.find(N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends