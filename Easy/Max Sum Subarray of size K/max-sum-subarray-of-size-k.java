//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        long currSum=0,  maxSum=0;
        if(K>N){
            return -1;
        }
        for(int i=0;i<K;i++){
            currSum += Arr.get(i);
        }
        maxSum=currSum;
        for(int i=K;i<N;i++){
            currSum = currSum - Arr.get(i - K) + Arr.get(i);
            // Update maxSum if the currentSum is greater
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}