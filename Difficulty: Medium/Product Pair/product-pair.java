//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (int)(Long.parseLong(a1[i]));
            }
            long x = Long.parseLong(br.readLine());
            boolean ans = new Solution().isProduct(arr, x);
            System.out.println(ans ? "true" : "false");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isProduct(int[] arr, long x) {
        Arrays.sort(arr);
        int start=0;
        int end=arr.length-1;
        while(start<end)
        {
            if((long)arr[start]*(long)arr[end]==x)
            {
                return true;
            }
            else if((long)arr[start]*(long)arr[end]>x)
            {
                end--;
            }
            else
            {
                start++;
            }
        }
        return false;
    }
}