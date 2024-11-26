//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        //maxSum in circular array
        //inverting all the elements and then applying kadanes algo
        
        int n =arr.length;
        int NormalSum = kadanesAlgo(arr);
        
        int cirSum = 0;
        for(int i = 0;i<n;i++){
            cirSum += arr[i];
            arr[i] = -arr[i];
        }
        
        int minSum = kadanesAlgo(arr);
        
        return Math.max(NormalSum,cirSum+minSum);
        
        
        
    }
    public int kadanesAlgo(int arr[]){
        int n = arr.length;
        int maxSum = arr[0];
        int maxEnding = arr[0];
        for(int i = 1;i<n;i++){
            maxEnding = Math.max(arr[i],arr[i]+maxEnding);
            
            maxSum = Math.max(maxEnding,maxSum);
        }
        return maxSum;
        
    }
}