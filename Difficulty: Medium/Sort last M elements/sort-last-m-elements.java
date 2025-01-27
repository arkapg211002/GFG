//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            String[] S = br.readLine().trim().split(" ");
            int[] nums = new int[n+m];
            for(int i = 0; i < S.length; i++)
                nums[i] = Integer.parseInt(S[i]);
            Solution obj = new Solution();
            obj.sortLastMelements(nums, n, m);
            for(int i = 0; i < nums.length; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    public void sortLastMelements(int[] nums, int n, int m)
    {
        // Code here
        // Step 1: Sort the last m elements
        Arrays.sort(nums, n, n + m);

        // Step 2: Merge the two sorted segments
        int[] result = new int[n + m];
        int i = 0, j = n, k = 0;

        while (i < n && j < n + m) {
            if (nums[i] <= nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }

        while (i < n) {
            result[k++] = nums[i++];
        }

        while (j < n + m) {
            result[k++] = nums[j++];
        }

        // Copy merged result back to the original array
        System.arraycopy(result, 0, nums, 0, n + m);        
    }
}