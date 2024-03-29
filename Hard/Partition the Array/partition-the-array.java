//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.minDifference(N, A); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long minDifference(int N, int A[]) 
    { 
       // Array to store prefix sums
        long[] prefixSums = new long[N + 1];
        // Calculate prefix sums
        prefixSums[0] = 0;
        for (int i = 1; i <= N; i++) {
            prefixSums[i] = prefixSums[i - 1] + A[i - 1];
        }
        
        // Initialize smallest difference to the sum of all elements
        long smallestDifference = prefixSums[N];
        
        // Iterate over all possible partitions P, Q, R, S of the array
        for (int i = 1; i < N - 2; i++) {
            
            // Calculate the minimum and maximum sums of P and Q
            MinMaxPair leftMinMax = getMinMaxSums(prefixSums, 1, i + 1);
            
            // Calculate the minimum and maximum sums of R and S
            MinMaxPair rightMinMax = getMinMaxSums(prefixSums, i + 2, N);
            
            // Calculate the maximum and minimum sums of the four partitions
            long maxSumPQ = leftMinMax.maxSum;
            long maxSumRS = rightMinMax.maxSum;
            long minSumPQ = leftMinMax.minSum;
            long minSumRS = rightMinMax.minSum;
            
            // Calculate the absolute difference between the maximum and minimum sums
            long absoluteDifference = Math.abs(Math.max(maxSumPQ, maxSumRS) - Math.min(minSumPQ, minSumRS));
            
            // Update the smallest difference if necessary
            smallestDifference = Math.min(smallestDifference, absoluteDifference);
        }
        
        // Return the smallest difference
        return smallestDifference;
    }
    
     static class MinMaxPair {
        long minSum, maxSum;
        public MinMaxPair(long minSum, long maxSum) {
            this.minSum = minSum;
            this.maxSum = maxSum;
        }
    }
    
    static MinMaxPair getMinMaxSums(long[] prefixSums, int left, int right) {
        
       // Initialize pointers lo and hi for binary search
        int lo = left, hi = right - 1;
        
        // Initialize minSum and maxSum to the minimum and maximum prefix sums of the entire range
        long minSum = 0, maxSum = prefixSums[right] - prefixSums[left - 1];
        
        // Perform binary search to find the minimum and maximum prefix sums
        while (lo <= hi) {
            
            // Calculate the prefix sum of the midpoint
            int mid = lo + (hi - lo) / 2;
            long leftSum = prefixSums[mid] - prefixSums[left - 1];
            long rightSum = prefixSums[right] - prefixSums[mid];
            
            /* Update minSum and maxSum if the absolute difference between the two sums is 
            smaller than the current difference*/
            if (Math.abs(rightSum - leftSum) < maxSum - minSum) {
                minSum = Math.min(leftSum, rightSum);
                maxSum = Math.max(leftSum, rightSum);
            }
            
            // If leftSum is smaller than rightSum, move the lo pointer to the right of the midpoint
            if (leftSum < rightSum) {
                lo = mid + 1;
            } 
            
            // Otherwise, move the hi pointer to the left of the midpoint
            else {
                hi = mid - 1;
            }
        }
        return new MinMaxPair(minSum, maxSum);
    }
}