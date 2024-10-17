//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S1 = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(S1[i]);
            int q = Integer.parseInt(br.readLine().trim());
            int[][] Queries = new int[q][3];
            for(int i = 0; i < q; i++){
                String[] S3 = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++){
                    Queries[i][j] = Integer.parseInt(S3[j]);
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.solveQueries(nums, Queries);
            for(int i = 0; i < ans.length; i++)
                System.out.println(ans[i]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] solveQueries(int[] nums, int[][] Queries) {
        List<Integer> result = new ArrayList<>();
        
        for (int[] query : Queries) {
            int type = query[0];
            int A = query[1] - 1;  // Convert 1-based index to 0-based index
            int B = query[2] - 1;
            
            if (type == 1) {
                // Update query: update nums[A] to B (adjusted for 0-based index)
                nums[A] = B + 1;  // Adjusting to the new value provided
            } else if (type == 2) {
                // Range query: Check if the subarray from index A to B is increasing, decreasing, or neither
                boolean isNonDecreasing = true;
                boolean isNonIncreasing = true;
                
                // Traverse the subarray and check both conditions
                for (int i = A; i < B; i++) {
                    if (nums[i] > nums[i + 1]) {
                        isNonDecreasing = false;
                    }
                    if (nums[i] < nums[i + 1]) {
                        isNonIncreasing = false;
                    }
                }
                
                if (isNonDecreasing && isNonIncreasing) {
                    result.add(-1);  // Subarray is constant (both non-decreasing and non-increasing)
                } else if (isNonDecreasing) {
                    result.add(0);   // Subarray is only non-decreasing
                } else if (isNonIncreasing) {
                    result.add(1);   // Subarray is only non-increasing
                } else {
                    result.add(-1);  // Subarray is neither
                }
            }
        }
        
        // Convert result list to array
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}