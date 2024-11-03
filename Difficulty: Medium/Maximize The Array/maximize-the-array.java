//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr1 = new int[n], arr2 = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            ArrayList<Integer> ans = new Solution().maximizeArray(arr1, arr2, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        TreeSet<Integer> set = new TreeSet<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++)

        {

            set.add(arr1[i]);

            set.add(arr2[i]);

        }  

        

        int size = set.size()-n;

        for(int i=0;i<size;i++)

         set.pollFirst();

        

        for(int val:arr2)

        {

            if(set.contains(val))

             {

                 result.add(val);

                 set.remove(val);

             }

        }

        

         for(int val:arr1)

        {

            if(set.contains(val))

             {

                 result.add(val);

                 set.remove(val);

             }

        }

       return result; 
    }
}