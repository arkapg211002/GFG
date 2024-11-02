//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        if(A == null || N < 3) {
            return -1;
        }
        
        Arrays.sort(A);
        
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=0; i<N-2; i++) {
            
            int l = i+1;
            int r = N-1;
            
            while(l<r) {
                
                int curSum = A[i] + A[l] + A[r];
                
                if(Math.abs(X-curSum) < minDiff) {
                    
                    minDiff = Math.abs(X-curSum);
                    sum = curSum;
                }
                if(curSum > X) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        
        return sum;
    }
}