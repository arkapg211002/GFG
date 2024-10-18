//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        if(arr.length==1)
        {
            return arr[0];
        }
        int ans = -1;
        HashMap<Integer, Integer>occ = new HashMap<>();
        for(int i = 0; i<arr.length; i++)
        {
            if(occ.containsKey(arr[i]))
            {
                occ.put(arr[i], occ.get(arr[i])+1);
            }
            else
            {
                occ.put(arr[i],1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : occ.entrySet()) {
            if(entry.getValue() > arr.length / 2) {
                return entry.getKey();
            }
        }
        return ans;
    }
}