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
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> arr, int n, int m)
    {
        if(arr == null || arr.size() < m)
            return 0l;
            
        Collections.sort(arr);
        int min = arr.get(m-1) - arr.get(0);
        int startIdx = 0;
        for(int i=m; i<n; i++) {
            startIdx++;
            min = Math.min(min, arr.get(i) - arr.get(startIdx));
        }
        
        return min;
    }
}