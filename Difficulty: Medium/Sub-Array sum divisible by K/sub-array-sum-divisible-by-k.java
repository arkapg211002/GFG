//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            long ans = ob.subCount(nums, d);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    // Function to count the number of subarrays with a sum that is divisible by K
    public long subCount(int[] arr, int k) {
        // code hereM
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,1);
        int n = arr.length, s = 0, res = 0;
        
        for(int i=0; i<n; i++){
            s += arr[i];
            int x = s%k;
            if(x<0) x += k;
            res += m.getOrDefault(x, 0);
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        
        return res;

    }
}

// 4 9 9 7 4 5
// 4 4 2 4 0