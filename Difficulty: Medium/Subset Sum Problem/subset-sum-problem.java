//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean [][] dp = new boolean[N + 1][sum + 1];
        dp[0][0] = true;
        
        for(int index = 1; index <= N; index++) {
            for(int currSum = 0; currSum <= sum; currSum++) {
                boolean take = false;
                if(arr[index - 1] <= currSum) {
                    take = dp[index - 1][currSum - arr[index - 1]];
                }
                
                boolean notake = dp[index - 1][currSum];
                
                dp[index][currSum] = take || notake;
            }
        }
        
        return dp[N][sum];
        
        
    }
    
    public static Boolean f(int index, int currSum, int [] arr) {
        if(index < 0) {
            if(currSum == 0) return true;
            else return false;
        }
        
        boolean take = false;
        
        if(arr[index] <= currSum) {
            take = f(index - 1, currSum - arr[index], arr);
        }
        
        boolean notake = f(index - 1, currSum, arr);
        
        return take || notake;
    }
}