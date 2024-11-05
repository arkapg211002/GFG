//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends



//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] bloomDay) {
        int maxi = Integer.MIN_VALUE , mini = Integer.MAX_VALUE;
        
        for(int x : bloomDay){
            maxi = Math.max(maxi , x);
            mini = Math.min(mini , x);
        }
        
        int low = mini , high = maxi;
        int ans = -1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            if(solve(mid , bloomDay , K) >= M){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return ans;
    }   
    
    public static int solve(int x , int [] arr , int k){
        int bou = 0 , cnt = 0;
        
        for(int a : arr){
            if(x >= a){
                cnt++;
            }
            else{
                cnt = 0;
            }
            
            if(cnt == k){
                bou++;
                cnt = 0;
            }
        }
        
        return bou;
    }
}