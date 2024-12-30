//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next ();
            int q1 = sc.nextInt();
            int q2 = sc.nextInt();
            if (q1 > q2){
                int temp = q1;
                q1 = q2;
                q2 = temp;
            }
    		System.out.println (new Sol().countPalinInRange (n, s, q1, q2));
        
System.out.println("~");
}
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends




//User function Template for Java

class Sol
{
    int countPalinInRange (int N, String S, int q1, int q2)
    {
        // your code here
        String newStr=S.substring(q1,q2+1);
        int n=newStr.length();
        boolean dp[][]=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(newStr.charAt(i)==newStr.charAt(i+1)){
                dp[i][i+1]=true;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(newStr.charAt(i)==newStr.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==true){
                    count++;
                }
            }
        }
        return count;
    }
}