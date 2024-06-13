// https://www.geeksforgeeks.org/problems/padovan-sequence2855/1

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
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
       int mod = (int)1e9+7;
        if(n<3){
            return 1;
        }
        int prev1=1;
        int prev2=1;
        int prev3=1;
        for(int i=3;i<=n;i++){
            int temp=prev1;
            prev1=(prev2+prev3)%mod;
            prev3=prev2;
            prev2=temp;
            
        }
        return prev1;
    }
    
}
