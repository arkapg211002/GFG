//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minAmount(A,n));
                
System.out.println("~");
}
        }
}    
// } Driver Code Ends






class Solution
{
  public int minAmount(int A[] , int N)
    {
        //code here.
        if(N==1) return A[0];
        int x=A[0],y=Math.max(A[0],A[1]);
        for(int i=2;i<N;i++){
            int k=Math.max(A[i]+x,y);
            x=y;
            y=k;
        }
        int sum=0;
        for(int a:A) sum+=a;
        return sum-y;
    }
}