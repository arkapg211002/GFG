//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
        {
        //complete the function here
            if(n==0){
                return 0;
            }
            int start = 5, end = n*5;
            while(start<=end){
                int mid = start+(end-start)/2;
                int cnt = 0;
                for(int i=5; mid/i>=1; i*=5){
                    cnt += (mid/i);
                }
                if(cnt >= n){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            return start;
        }
}