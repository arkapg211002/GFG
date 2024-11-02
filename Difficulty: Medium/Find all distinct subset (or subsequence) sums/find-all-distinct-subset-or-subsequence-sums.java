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
            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            int[] ans = obj.DistinctSum(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution
{
    public int[] DistinctSum(int[] nums)
    {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Step 2: Create a TreeSet to store distinct sums (automatically sorted)
        TreeSet<Integer> distinctSums = new TreeSet<>();
        
        // Step 3: Initialize a boolean array to track possible sums
        boolean[] possibleSums = new boolean[totalSum + 1];
        possibleSums[0] = true;  // Sum of 0 is always possible
        
        // Step 4: Iterate through each number in the input array
        for (int num : nums) {
            // Update possible sums array from the back to avoid overwriting
            for (int i = totalSum; i >= num; i--) {
                if (possibleSums[i - num]) {
                    possibleSums[i] = true;
                }
            }
        }
        
        // Step 5: Collect all distinct sums
        for (int i = 0; i <= totalSum; i++) {
            if (possibleSums[i]) {
                distinctSums.add(i);
            }
        }
        
        // Step 6: Convert the TreeSet to an array and return it
        int[] result = new int[distinctSums.size()];
        int index = 0;
        for (int sum : distinctSums) {
            result[index++] = sum;
        }
        
        return result;
    }
}