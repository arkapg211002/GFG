//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    
    
    public static int sumDiv(int [] nums, int x)
    {
        int sum=0;
        for(int i:nums)
        {
            sum+=Math.ceil((float)i/x);
        }
        return sum;
    }
    
    
    public static int smallestDivisor(int[] nums, int K) 
    {
        int max=nums[0];
        
        for(int i:nums)
        {
            if(max<i) max=i;
        }
        
        int low=1;
        int high=max;
        
        int mid;
        int ans=-1;
        
        while(low<=high)
        {
            mid=low+(high-low)/2;
            
            if(sumDiv(nums,mid)<=K) 
            {   
                high=mid-1;
                ans=mid;
            }
            
            else 
            {
                    low=mid+1;
                    
            }
            
        }
        return ans;
        
        
    }
}